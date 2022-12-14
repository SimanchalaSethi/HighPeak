package hp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MaximumEarnings {
	public static void main(String[] args) throws Exception {

		FileInputStream fin = new FileInputStream("G:\\IOPackage\\input3.txt");
		String s = "" + (char) fin.read();
		int n = Integer.parseInt(s);
		fin.read();
		ArrayList<String[]> ls = new ArrayList<String[]>();

		int index = 0;
		int count = 0;

		int r = fin.read();
		String str = "";
		String[] ss = new String[3];
		int i = 0;
		while (r != -1) {

			if (r == 13) {
				ss[i] = str;
				str = "";
				if (i == 2) {
					ls.add(ss);
					ss = new String[3];
					i = 0;
				} else
					i++;

			} else {
				str = str + (char) r;
				count++;
			}

			r = fin.read();
			if (r == -1) {
				ss[i] = str;
				ls.add(ss);
			}
		}
		ss[i] = str;

		int max = 0;
		for (String[] st : ls) {
			int c = Integer.parseInt(st[2].trim());
			if (c > max) {
				max = c;
				index = ls.indexOf(st);
			}

		}
		int sum = 0;
		for (i = 0; i < ls.size(); i++) {
			if (i != index)
				sum = sum + Integer.parseInt(ls.get(i)[2].trim());

		}

		FileOutputStream fos = new FileOutputStream("G:\\IOPackage\\output3.txt");
		String r1 = ls.size() - 1 + "";
		String s2 = sum + "";
		fos.write(r1.getBytes());
		fos.write(13);
		fos.write(s2.getBytes());
		fos.close();
		fin.close();
	}
}
