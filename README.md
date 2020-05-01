# Dagger Tutorial 

## Component - `@Component`

 - an interface or abstract class for which a __fully-formed, dependency-injected implementation__ is to be generated __from a set of modules()__
 - generated class will have same name as __type__ annotated with `@Component` prepended with `Dagger`
   
   ```java
   //annotated type 
   @Component interface MyComponent {   
     //...
   }
   
   //generated fully-formed implementation
   public final class DaggerMyComponent{   
     //...
   } 
   ```
 - __MUST__ contain at-least 1 abstract component method
    - can have any names
    - must have signatures that confirm either to `provision` (or) `members-injection` contract.
      - `Provision Methods` 
        - No parameters
        - return type = injected (or) provided type.
          ```java
            interface SomeComponent{
              SomeType getSomeType();
          }
          ```
      - `Members-Injection Methods`
        - Have a Single parameter
        - return type = void (or) The Single Parameter's Type
        - Inject dependencies into each of the **Inject-annotated fields and methods of the passed instance**.
          ```java
          interface SomeComponent{ 
              void injectSomeType(SomeType someType);
              SomeType injectAndReturnSomeType(SomeType someType);
          }
          ```

## Modules - `@Module`

- Annotates a class that `contributes to the object graph`.
- __classes__ or __interfaces__ that act as "collection of instructions" for Dagger on how to construct dependencies.
- Ways to construct dependencies.
  1. `@Binds` annotated abstract methods
  2. `@Provides` annotated concrete methods 
  
        
## Scope Annotations - `@Scope` 

- Instructs Dagger to provide __one shared instance for all the requests 
  for that type__ within an instance of the (sub)component that shares the same annotation.
- Applies to a class __containing__ `injectable constructor`
- governs how the injector re-uses instances of the Scope applied `type`. 
- Examples
  - `@Singleton` - a scoped binding that instructs injector to create only 1 instance.
    - Dagger either used `DoubleCheck` (or) `Instance-Holder` pattern to implement singleton.
    - If the `@Inject` constructor is no-arg then `Instance-Holder` pattern is used.
    - If the `@Injec` constructor has arguments then `DoubleCheck` is used at creation site. 
      (that is the Component Factory `initialize()` method).
- Common Errors
  - un-scoped components may not reference scoped bindings
  

## Qualifiers - `@Qualifier`

- Sometimes `type` alone is insufficient to identify a dependency. We need qualifiers in those case.
- used to __differentiate between instances of the same type that are unrelated__.
- Example1
  ```java
      @Module
      interface ElectricHeaterModule { 
        @Provides @Named("hot plate") static Heater provideHotPlateHeater() {
          return new ElectricHeater(70);
        }
                    
        @Provides @Named("water") static Heater provideWaterHeater() {
          return new ElectricHeater(93);
        }
      }   
      class ExpensiveCoffeeMaker {
        @Inject @Named("water") Heater waterHeater;
        @Inject @Named("hot plate") Heater hotPlateHeater;
        //...
      }
  ```
  >Explanation: ElectricHeaterModule provides 2 instance of __type Heater__. At injection site, we have to add 
  > qualifier to specify which "labelled/qualified instance" we want.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 > 
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      >
- Example2: 
  ```java
      /** Qualifier for the currently logged-in user. */
      @Retention(RUNTIME)
      @Qualifier
      @Documented
      @interface Username {}
  
      @Component(modules = AccountModule.class)
      interface AccountsFactory {
        @Component.Factory
        interface Factory{
          //Binds userName to the AccountsFactory instance.
          AccountsFactory create(@BindsInstance @Username String username);
        }
      }
      @Module
      interface AccountModule {
        @Provides
        //Since Account Module is bound to AccountsFactory component, userName is passed from bound
        // instance variable "userName" of AccountsFactory. 
        static Account accountFor(@Username String userName) {
          return new Account(userName);
        }
      } 
  ```
  
## `@Inject` constructor vs `@Binds` abstract method  vs `@Provides` concrete method

- `@Inject` is uses in a constructor of any concrete class that is visible to a component.
- `@Binds` is used in a `module`'s abstract method to bind 
  it's __parameter__ (a concrete type) to it's __return type__ (an abstract type).
- `@Provides` is used in a  `module`'s concrete method to bind a 
  it's __return type__ (an abstract type) to it's __returned value__ (a concrete type).