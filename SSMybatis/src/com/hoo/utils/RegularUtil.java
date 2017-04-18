package com.hoo.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*常用正则表达式
[size=12px]1。^\d+$　　//匹配非负整数（正整数 + 0） 
2。^[0-9]*[1-9][0-9]*$　　//匹配正整数 
3。^((-\d+)|(0+))$　　//匹配非正整数（负整数 + 0） 
4。^-[0-9]*[1-9][0-9]*$　　//匹配负整数 
5。^-?\d+$　　　　//匹配整数 
6。^\d+(\.\d+)?$　　//匹配非负浮点数（正浮点数 + 0） 
7。^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$　　//匹配正浮点数 
8。^((-\d+(\.\d+)?)|(0+(\.0+)?))$　　//匹配非正浮点数（负浮点数 + 0） 
9。^(-(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*)))$　　//匹配负浮点数 
10。^(-?\d+)(\.\d+)?$　　//匹配浮点数 
11。^[A-Za-z]+$　　//匹配由26个英文字母组成的字符串 
12。^[A-Z]+$　　//匹配由26个英文字母的大写组成的字符串 
13。^[a-z]+$　　//匹配由26个英文字母的小写组成的字符串 
14。^[A-Za-z0-9]+$　　//匹配由数字和26个英文字母组成的字符串 
15。^\w+$　　//匹配由数字、26个英文字母或者下划线组成的字符串 
16。^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$　　　　//匹配email地址 
17。^[a-zA-z]+://匹配(\w+(-\w+)*)(\.(\w+(-\w+)*))*(\?\S*)?$　　//匹配url 
18。匹配中文字符的正则表达式： [\u4e00-\u9fa5] 
19。匹配双字节字符(包括汉字在内)：[^\x00-\xff]
20。应用：计算字符串的长度（一个双字节字符长度计2，ASCII字符计1）
String.prototype.len=function(){return this.replace([^\x00-\xff]/g,"aa").length;} 
21。匹配空行的正则表达式：\n[\s| ]*\r 
22。匹配HTML标记的正则表达式：/<(.*)>.*<\/\1>|<(.*) \/>/ 
23。匹配首尾空格的正则表达式：(^\s*)|(\s*$)

* 正则表达式用例
* 1、^\S+[a-z A-Z]$ 不能为空 不能有空格  只能是英文字母
* 2、\S{6,}         不能为空 六位以上
* 3、^\d+$          不能有空格 不能非数字
* 4、(.*)(\.jpg|\.bmp)$ 只能是jpg和bmp格式
* 5、^\d{4}\-\d{1,2}-\d{1,2}$ 只能是2004-10-22格式
* 6、^0$            至少选一项
* 7、^0{2,}$        至少选两项
* 8、^[\s|\S]{20,}$ 不能为空 二十字以上
* 9、^\+?[a-z0-9](([-+.]|[_]+)?[a-z0-9]+)*@([a-z0-9]+(\.|\-))+[a-z]{2,6}$邮件
* 10、\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*([,;]\s*\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*)* 输入多个地址用逗号或空格分隔邮件
* 11、^(\([0-9]+\))?[0-9]{7,8}$电话号码7位或8位或前面有区号例如（022）87341628
* 12、^[a-z A-Z 0-9 _]+@[a-z A-Z 0-9 _]+(\.[a-z A-Z 0-9 _]+)+(\,[a-z A-Z 0-9 _]+@[a-z A-Z 0-9 _]+(\.[a-z A-Z 0-9 _]+)+)*$
*     只能是字母、数字、下划线；必须有@和.同时格式要规范 邮件
* 13 ^\w+@\w+(\.\w+)+(\,\w+@\w+(\.\w+)+)*$上面表达式也可以写成这样子，更精练。
14   ^\w+((-\w+)|(\.\w+))*\@\w+((\.|-)\w+)*\.\w+$ [/size]
*/
 
/** 
 * <p>Description:验证帮助类  </p>
 * @author  zhys(13960826213@139.com)
 * @created 2012-3-20
 */
public class RegularUtil {

	
 
	/**
     * @since 验证字符长度
     * describe:验证最大长度，去除空格，长度1-最大长度
     * @param str验证字符串
     * @param maxlength最大长度
	 * @return
	 */
	public static boolean  regularLength(String str,int maxlength){
		if(str==null){
			return false;
		}else{
			StringBuffer regular=new StringBuffer("^[\\s|\\S]{1,");
			regular.append(maxlength);
			regular.append("}$");
			if(str.trim().matches(regular.toString())){
				return true;
			}else{
				return false;
			}
		}
	}
	
 
	/** 
     *  @since 验证字符长度
     *  describe:验证最大长度，去除空格，长度1-最大长度
     *  @param str验证字符串
     *  @param maxlength最大长度
     *  @return 
	 */
	public static boolean  regularNumber(String str,int maxlength){
		if(str==null){
			return false;
		}else{
			StringBuffer regular=new StringBuffer("^[0-9]{1,");
			regular.append(maxlength);
			regular.append("}$");
			if(str.trim().matches(regular.toString())){
				return true;
			}else{
				return false;
			}
		}
	}
	
 
    public static boolean  regularNum(String str,int maxlength){
        if(str==null){
            return false;
        }else{
            StringBuffer regular=new StringBuffer("\\$\\d+[\\.]?\\d*");
            regular.append(maxlength); 
            if(str.trim().matches(regular.toString())){
                return true;
            }else{
                return false;
            }
        }
    }
    
    /**
     * <p>获取最后一个数字串</p> 
     * @author zhys
     * @param str
     * @return
     */ 
    public static String getNum(String str) {
        String regex = "\\d*\\.\\d.*|\\d*";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        List<String> list = new ArrayList<String>();
        while (m.find()) {
            if (!"".equals(m.group()))
                list.add(m.group());
            // System.out.println("come here:" + m.group());
        }
        if (list.size() > 0) {
            return list.get(list.size()-1);
        }
        return null;
    }
}
