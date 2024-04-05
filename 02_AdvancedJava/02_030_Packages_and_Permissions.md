# 02.030 Packages and Permissions

A package is a group of related classes. 

Packages are not synonymous with Inheritance

* A package often contains multiple related classes.
* The classes do not need to be in an inheritance relationship
* Inheritance may cross packages, especially if they are by different sources
## Packages
### Importing packages

An entire package may be imported with *.

It is a bad idea to import all of a large package.

### Package names

Packages use the domain-name-backwards method of naming

Each string between the periods represents a directory.  Both VS code and Intellij tend to make the subdirectory structure invisible

Most IDEs allow you to create packages in the same way you create classes.  The IDE takes care of the directory structure.

## Access Control (Permissions)

The following table is from most restrictive to least restrictive.  Notice that it drops off predictably.  "Default" is not at an extreme.

Modifier|Class|Package|Subclass|World
:---|:---:|:---:|:---:|:---:
public|Y|Y|Y|Y
protected|Y|Y|Y|N
*default*|Y|Y|N|N
private|Y|N|N|N

The default class happens when no specifier is given

Classes may *always* access members of its own class.

Sun and Oracle recommend that fields be private unless otherwise noted.  I wonder why they didn't make private the default.

The thing that seems to be missing is only allowing subclasses access  The way to handle this situation is to make a companion class and make it `protected.`