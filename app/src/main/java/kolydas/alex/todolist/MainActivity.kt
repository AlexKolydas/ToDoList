package kolydas.alex.todolist

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
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

        //Realm Fun

        val realm=Realm.getDefaultInstance()

        realm.beginTransaction() //BEGIN Realm

        var myDawg= realm.createObject(Dog::class.java)
        myDawg.name="Azor"
        myDawg.age=14

        realm.commitTransaction() //END Realm

        //Create a query object
        val query =realm.where(Dog::class.java)
        val results = query.findAll()

        for(dog in results){
            println(dog.name)
        }

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
