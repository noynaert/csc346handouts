# 02.040 Exception

Reference [rollbar.com](https://rollbar.com/blog/java-exceptions-hierarchy-explained/#:~:text=In%20Java%20%E2%80%9Can%20event%20that,run%2Dtime%20in%20application%20code.)

![Greatly simplified Exception Hierarchy](images/exceptions1.jpg)

* Errors are usually thrown by the JVM itself.  They are very, very rarely called.  They do not need to be caught.
* Exceptions are thrown by user-written programs
  * Runtime exceptions do not have to be caught.  In many situations they are fairly easy to fix on the spot and do not require an exit.
  * All non-Runtime errors must be caught.

## Checked vs Unchecked

Unchecked exceptions include Errors and Runtime Exceptions.  They do *not* need to be caugt.

Checked exceptions are all Other Exceptions.

![Simplified Exception Hierarchy](images/java-exceptions-hierarchy-example.png)

## Extending exceptions

All (I think all) Exceptions may be extended.

Reference [https://www.baeldung.com/java-new-custom-exception](https://www.baeldung.com/java-new-custom-exception)

