package sample;

/**
 * Created by Olya on 10.12.2016.
 */

public class FFT {

    public static void fftMatrix(Complex[][] series) {
        for (int i = 0; i < series.length; i++) {
            int count = (int)Math.pow(2, Math.floor(Math.log10(series[i].length) / Math.log10(2)));
            Complex[] row = new Complex[count];
            for (int j = 0; j < row.length; j++) {
                row[j] = series[i][j];
            }
            FFT.fft(row);
            Complex[] temp = new Complex[row.length / 2];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = row[j];
            }
            series[i] = temp;
        }
    }

    public static int bitReverse(int n, int bits) {
        int reversedN = n;
        int count = bits - 1;

        n >>= 1;
        while (n > 0) {
            reversedN = (reversedN << 1) | (n & 1);
            count--;
            n >>= 1;
        }

        return ((reversedN << count) & ((1 << bits) - 1));
    }

    static void fft(Complex[] buffer) {

        int bits = (int) (Math.log(buffer.length) / Math.log(2));
        for (int j = 1; j < buffer.length / 2; j++) {

            int swapPos = bitReverse(j, bits);
            Complex temp = buffer[j];
            buffer[j] = buffer[swapPos];
            buffer[swapPos] = temp;
        }

        for (int N = 2; N <= buffer.length; N <<= 1) {
            for (int i = 0; i < buffer.length; i += N) {
                for (int k = 0; k < N / 2; k++) {

                    int evenIndex = i + k;
                    int oddIndex = i + k + (N / 2);
                    Complex even = buffer[evenIndex];
                    Complex odd = buffer[oddIndex];

                    double term = (-2 * Math.PI * k) / (double) N;
                    Complex exp = (new Complex(Math.cos(term), Math.sin(term)).mult(odd));

                    buffer[evenIndex] = even.add(exp);
                    buffer[oddIndex] = even.sub(exp);
                }
            }
        }
    }
}

