package kolydas.alex.todolist

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class ToDoItem: RealmObject() {

     @PrimaryKey
     private var id= UUID.randomUUID().toString()
     var name=""
     var important=false

     fun getId(): String{
          return id
     }

     //return just the name into the listview(because it was shown name.walk the dog(or whatever i typed) and important=false(or true)
     override fun toString(): String {
          return name
     }
}