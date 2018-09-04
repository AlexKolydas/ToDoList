package kolydas.alex.todolist

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            var addIntent = Intent(this,AddToDoActivity::class.java)
            startActivity(addIntent)
        }

    }

    //if i had the Realm Fun code block in oncreate() it would run only 1 time.But onResume() it runs everytime i open the activity
    override fun onResume() {
        super.onResume()
        //Realm Fun
        val realm=Realm.getDefaultInstance()

        //Create a query object for realm
        val query =realm.where(ToDoItem::class.java)
        val results = query.findAll()

        val listView=findViewById<ListView>(R.id.toDoListView)

        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedToDo =results[position]
            val finishIntent=Intent(this,FinishActivity::class.java)
            finishIntent.putExtra("toDoItem",selectedToDo!!.getId())
            startActivity(finishIntent)
        }

        val adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,results)
        listView.adapter=adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
