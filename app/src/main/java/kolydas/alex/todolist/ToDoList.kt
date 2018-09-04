package kolydas.alex.todolist

import android.app.Application
import io.realm.Realm

 class ToDoList:Application(){

     override fun onCreate() {
        super.onCreate()

        //Realm
        //Init realm
        Realm.init(this)
    }


}