package kolydas.alex.todolist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import io.realm.Realm

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        title="Complete ToDo"

        //get the specific item from list to show on screen(with the UUID)
        val toDoItemId=intent.getStringExtra("toDoItem")

        val realm= Realm.getDefaultInstance()

        val toDoItem=realm.where(ToDoItem::class.java).equalTo("id",toDoItemId).findFirst()


        val textView= findViewById<TextView>(R.id.toDoNameTextView)
        textView.text=toDoItem!!.name

        val completeBtn=findViewById<Button>(R.id.completeBtn)

        //delete the item when user press the complete button
        completeBtn.setOnClickListener{
            realm.beginTransaction()
            toDoItem.deleteFromRealm()
            realm.commitTransaction()

            finish()
        }

    }
}
