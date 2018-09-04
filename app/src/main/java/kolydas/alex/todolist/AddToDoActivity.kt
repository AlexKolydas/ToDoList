package kolydas.alex.todolist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import io.realm.Realm

class AddToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_do)

        title="New To Do"

        val button = findViewById<Button>(R.id.addButton)
        val edtText=findViewById<EditText>(R.id.toDoEditBox)
        val checkBox=findViewById<CheckBox>(R.id.importantCheckBox)

        button.setOnClickListener{

            val toDo=ToDoItem()
            toDo.name=edtText.text.toString()
            toDo.important=checkBox.isChecked

            val realm = Realm.getDefaultInstance()
            realm.beginTransaction()
            realm.copyToRealm(toDo)
            realm.commitTransaction()

            finish()
        }
    }
}
