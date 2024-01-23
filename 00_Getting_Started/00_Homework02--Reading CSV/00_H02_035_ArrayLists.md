# 00.H02.035 ArrayLists

[ArrayList in the API](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayList.html)

ArrayLists work in a way that is similar to arrays.  However, you do not need to specify a maximum size for the array in advance.  ArrayLists are created with an initial size.  The default is 10.  If you try to add to a full list, the capacity of the list is doubled before the item is added.

Doubling the size of the list is a slow process.  Therefore if you have a rough idea of the actual size of the array, it is good to specify it when the array is created.
