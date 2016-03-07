package smartphone.app.project.fashionapplication.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import smartphone.app.project.fashionapplication.Activity.Sample.KanazawaSampleActivity;
import smartphone.app.project.fashionapplication.Activity.Sample.ProductionSampleActivity;
import smartphone.app.project.fashionapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this,KanazawaSampleActivity.class);
        startActivity(intent);
    }

    private void dammy(){
        Intent intent = new Intent(MainActivity.this, ProductionSampleActivity.class);
        startActivity(intent);
    }
}
