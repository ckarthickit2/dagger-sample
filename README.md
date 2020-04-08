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
             SomeType getSomeType();
          ```
      - `Members-Injection Methods`
        - Single parameter
        - return type = void (or) The Single Parameter's Type
        - Inject dependencies into each of the **Inject-annotated fields and methods of the passed instance**.
        
    
 