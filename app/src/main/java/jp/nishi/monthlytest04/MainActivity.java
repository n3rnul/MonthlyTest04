package jp.nishi.monthlytest04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	private TextView tvCalc;
	private boolean flgPushNum = true;
	private double val01 = 0.0;
	private int tmpKigo = 1;
	private double valMem;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tvCalc = findViewById(R.id.textView);
	}

	public void pushNum(View view) {

		if(tvCalc.getText().toString().equals("0") || flgPushNum) {

			tvCalc.setText(view.getTag().toString());
			flgPushNum =false;
		} else {

			tvCalc.append(view.getTag().toString());
		}
	}

	public void pushKigo(View view) {

		if (flgPushNum) {
			tmpKigo = Integer.parseInt(view.getTag().toString());
			return;
		}

		double val02 = Double.parseDouble(tvCalc.getText().toString());

		switch (tmpKigo) {
			case 1:
				val01 += val02;
				break;
			case 2:
				val01 -= val02;
				break;
			case 3:
				val01 *= val02;
				break;
			case 4:
				val01 /= val02;
				break;
			case 5:
				val01 = val02;
				break;
		}

		if (val02 != 0) {
			tvCalc.setText(String.valueOf(val01));
		} else {
			val01 = 0;
			tvCalc.setText("0で割れません。");
		}

		tmpKigo = Integer.parseInt(view.getTag().toString());
		flgPushNum = true;
	}

	public void pushClear(View view) {

		tvCalc.setText("0");
		flgPushNum = true;
		val01 = 0;
		tmpKigo = 1;
	}

	public void pushReverse(View view) {

		double val02 = Double.parseDouble(tvCalc.getText().toString()) * -1;
		tvCalc.setText(String.valueOf(val02));
	}

	public void pushPercent(View view) {

		double val02 = Double.parseDouble(tvCalc.getText().toString()) / 100;
		tvCalc.setText(String.valueOf(val02));
	}

	public void pushMclear(View view) {

		valMem = 0;
		flgPushNum = true;
		tmpKigo = 1;
	}

	public void pushMtasu(View view) {

		valMem += Double.parseDouble(tvCalc.getText().toString());
		flgPushNum = true;
		tmpKigo = 1;
	}

	public void pushMhiku(View view) {

		valMem -= Double.parseDouble(tvCalc.getText().toString());
		flgPushNum = true;
		tmpKigo = 1;
	}

	public void pushMrecall(View view) {

		tvCalc.setText(String.valueOf(valMem));
		flgPushNum = true;
		tmpKigo = 1;
	}
}
