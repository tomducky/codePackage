package com.bzu.util;

import java.io.FileOutputStream;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class WorkMapUtil {

	/**
	 * ����������ʾ��򵥵���״ͼ����
	 * 
	 * @author Winter Lau
	 */

	public static void creatMap(CategoryDataset dataset, String file,int num)
			throws IOException {
		JFreeChart chart = ChartFactory.createBarChart3D("Ա�����³���ͳ��ͼ", // ͼ�����
				"��Ա", // Ŀ¼�����ʾ��ǩ
				"��������", // ��ֵ�����ʾ��ǩ
				dataset, // ���ݼ�
				PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
				true, // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
				false, // �Ƿ����ɹ���
				false // �Ƿ�����URL����
				);
		FileOutputStream fos_jpg = null;
		try {
			fos_jpg = new FileOutputStream(file);
			ChartUtilities
					.writeChartAsJPEG(fos_jpg, 1.0f, chart, 60*num, 560, null);
		} finally {
			try {
				fos_jpg.close();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * ��ȡһ����ʾ�õļ����ݼ�����
	 * 
	 * @return
	 */

	public static void main(String[] args) {
		System.out.println(800/15);
	}
}
