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
	 * 该类用于演示最简单的柱状图生成
	 * 
	 * @author Winter Lau
	 */

	public static void creatMap(CategoryDataset dataset, String file,int num)
			throws IOException {
		JFreeChart chart = ChartFactory.createBarChart3D("员工本月出勤统计图", // 图表标题
				"人员", // 目录轴的显示标签
				"出勤天数", // 数值轴的显示标签
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				true, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false // 是否生成URL链接
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
	 * 获取一个演示用的简单数据集对象
	 * 
	 * @return
	 */

	public static void main(String[] args) {
		System.out.println(800/15);
	}
}
