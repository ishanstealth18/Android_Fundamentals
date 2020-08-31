package stealth.ishan.text_scrollview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        //return super.onContextItemSelected(item);
        switch (item.getItemId())
        {
            case (R.id.edit):
                displayToast("Edit is selected.");
                return true;
            case (R.id.share):
                displayToast("Share is selected.");
                return true;
            case (R.id.delete):
                displayToast("Delete is selected.");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflator = getMenuInflater();
        inflator.inflate(R.menu.menu_context,menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView article_text = findViewById(R.id.article);
        registerForContextMenu(article_text);
    }
}