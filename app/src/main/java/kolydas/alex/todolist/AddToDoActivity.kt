package kolydas.alex.todolist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class AddToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_do)

        title="New To Do"
    }
}
