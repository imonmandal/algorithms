import java.io.*;
import java.util.*;

public class Solution {
    static FastIO io = new FastIO();

    static void solve(int testCase) {
        
    }

    public static void main(String[] args) {
        int t = 1;
        t = io.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            solve(tc);
        }

        io.close();
    }

    static class FastIO {
        private BufferedReader br;
        private StringTokenizer st;
        private PrintWriter pw;

        public FastIO() {
            br = new BufferedReader(new InputStreamReader(System.in));
            pw = new PrintWriter(System.out);
        }

        public FastIO(String inputFile, String outputFile) throws IOException {
            br = new BufferedReader(new FileReader(inputFile));
            pw = new PrintWriter(new FileWriter(outputFile));
        }

        public String next() {
            if (st == null || !st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) {
                        return null;
                    }
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return st.hasMoreTokens() ? st.nextToken() : "";
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            try {
                if (st != null && st.hasMoreTokens()) {
                    return st.nextToken("\n");
                }
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) pw.print(' ');
                pw.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            pw.println();
        }

        public void close() {
            pw.close();
        }
    }
}
