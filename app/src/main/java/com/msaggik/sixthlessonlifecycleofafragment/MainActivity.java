package com.msaggik.sixthlessonlifecycleofafragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.msaggik.sixthlessonlifecycleofafragment.fragments.FirstFragment;
import com.msaggik.sixthlessonlifecycleofafragment.fragments.SecondFragment;
import com.msaggik.sixthlessonlifecycleofafragment.fragments.ThirdFragment;

public class MainActivity extends AppCompatActivity {

    // поля
    private Button buttonFirstFragment, buttonSecondFragment, buttonThirdFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // привязка разметки к полям
        buttonFirstFragment = findViewById(R.id.button_first_fragment);
        buttonSecondFragment = findViewById(R.id.button_second_fragment);
        buttonThirdFragment = findViewById(R.id.button_third_fragment);

        // обработка нажатия кнопок
        buttonFirstFragment.setOnClickListener(listener);
        buttonSecondFragment.setOnClickListener(listener);
        buttonThirdFragment.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Fragment fragment = null; // объявление фрагмента

            switch (view.getId()) {
                case R.id.button_first_fragment:
                    fragment = new FirstFragment(); // инициализация первым фрагментом
                    break;
                case R.id.button_second_fragment:
                    fragment = new SecondFragment(); // инициализация вторым фрагментом
                    break;
                case R.id.button_third_fragment:
                    fragment = new ThirdFragment(); // инициализация третьим фрагментом
                    break;
            }

            if (fragment != null) {
                // загрузка фрагмента в контейнер FrameLayout с id container_fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, fragment).commit();
            }
        }
    };
}