package text.bwie.com.liuxixin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviewandbutton();
 }
 private void findviewandbutton(){
     //自定义的view
     final Zhuandong panView= (Zhuandong) this.findViewById(R.id.zhuandong);
     //开始旋转的按钮
     Button startbutton= (Button) this.findViewById(R.id.startButton);
     startbutton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

         }
     });

     //停止旋转的按钮
     Button stopButton= (Button) this.findViewById(R.id.stopButton);

     stopButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
          
         }
     });
 }



}
