package kolydas.alex.todolist

import io.realm.RealmObject

open class ToDoItem: RealmObject() {

     var name=""
     var important=false

     //return just the name into the listview(because it was shown name.walk the dog(or whatever i typed) and important=false(or true)
     override fun toString(): String {
          return name
     }
}