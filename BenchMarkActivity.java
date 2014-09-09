package com.rakesh.sort_benchmark;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BenchMarkActivity extends Activity {

	EditText etArrayLength;
	TextView tvStatus;
	TextView tvBubbleSort;
	TextView tvSelectionSort;
	TextView tvInsertionSort;
	TextView tvMergeSort;
	TextView tvQuickSort;
	int[] array;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bench_mark_layout);
		etArrayLength = (EditText) findViewById(R.id.etArrayLength);
		tvBubbleSort = (TextView) findViewById(R.id.tvBubbleSort);
		tvSelectionSort = (TextView) findViewById(R.id.tvSelectionSort);
		tvInsertionSort = (TextView) findViewById(R.id.tvInsertionSort);
		tvMergeSort = (TextView) findViewById(R.id.tvMergeSort);
		tvQuickSort = (TextView) findViewById(R.id.tvQuickSort);
		tvStatus = (TextView) findViewById(R.id.tvStatus);
	}
	
	public void compute(View view)
	{
		try
		{
			int len = Integer.parseInt(etArrayLength.getText().toString());
			double time;
			
			switch(view.getId())
			{
			case R.id.btnGen: 			array = Sort.createArray(len);
										tvStatus.setText("Array of Length " + len + " is created");
										break;
										
			case R.id.btnBubbleSort:	time = Sort.bubbleSort(Sort.duplicateArray(array));
										tvBubbleSort.setText("" + time + "ms");
										break;
										
			case R.id.btnSelectionSort:	time = Sort.selectionSort(Sort.duplicateArray(array));
										tvSelectionSort.setText("" + time + "ms");
										break;
										
			case R.id.btnInsertionSort:	time = Sort.insertionSort(Sort.duplicateArray(array));
										tvInsertionSort.setText("" + time + "ms");
										break;
										
			case R.id.btnMergeSort:		time = System.currentTimeMillis();
										Sort.mergeSort(Sort.duplicateArray(array));
										tvMergeSort.setText("" + (System.currentTimeMillis()-time) + "ms");
										break;
										
			case R.id.btnQuickSort:		time = System.currentTimeMillis();
										Sort.qs(Sort.duplicateArray(array));
										tvQuickSort.setText("" + (System.currentTimeMillis()-time) + "ms");
										break;
			}
		}
		catch(Exception e)
		{
			tvStatus.setText("Enter Array length");
		}
	}
}

			
			
			
			
			
			
