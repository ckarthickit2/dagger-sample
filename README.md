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

- Applies to a class __containing__ `injectable constructor`
- governs how the injector re-uses instances of the Scope applied `type`.
- Examples
  - `@Singleton` - a scoped binding that instructs injector to create only 1 instance.
- Common Errors
  - un-scoped components may not reference scoped bindings