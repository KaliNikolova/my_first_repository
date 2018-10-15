import java.util.Random;

public class WarA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[52];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		for (int i = 0; i < arr.length; i++) {
			Random generator = new Random();
			int randomIndex = generator.nextInt(arr.length);
			int help = arr[i];
			arr[i] = arr[randomIndex];
			arr[randomIndex] = help;
		}
		int[] a = new int[52];
		int[] b = new int[52];
		int[] c = new int[52];
		int[] d = new int[52];
		for (int i = 0; i < 52 * 4; i++) {
			if (i % 4 == 0) {
				if (i < 52) {
					a[i / 4] = arr[i];
				} else {
					a[i / 4] = -1;
				}
			}
			if (i % 4 == 1) {
				if (i < 52) {
					b[i / 4] = arr[i];
				} else {
					b[i / 4] = -1;
				}
			}
			if (i % 4 == 2) {
				if (i < 52) {
					c[i / 4] = arr[i];
				} else {
					c[i / 4] = -1;
				}
			}
			if (i % 4 == 3) {
				if (i < 52) {
					d[i / 4] = arr[i];
				} else {
					d[i / 4] = -1;
				}
			}
		}
		System.out.print("Igrach A: ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.print("\nIgrach B: ");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.print("\nIgrach C: ");
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i] + " ");
		}
		System.out.print("\nIgrach D: ");
		for (int i = 0; i < d.length; i++) {
			System.out.print(d[i] + " ");
		}
		int i = 0;
		int aCounter = 13;
		int bCounter = 13;
		int cCounter = 13;
		int dCounter = 13;
		while (a[51] == -1 && b[51] == -1 && c[51] == -1 && d[51] == -1) {
			i++;
			System.out.print("\nRazdavane " + i + ": " + a[0] + " " + b[0] + " " + c[0] + " " + d[0]);
			if (a[0]%13 > b[0]%13 && a[0]%13 > d[0]%13 && a[0]%13 > c[0]%13) {
				
				prenarejdane(a, b, c, d, aCounter, bCounter, cCounter, dCounter);
				if(b[0]==-1) {
					bCounter++;
					aCounter--;
				}
				if(c[0]==-1) {
					cCounter++;
					aCounter--;
				}
				if(d[0]==-1) {
					dCounter++;
					aCounter--;
				}
				aCounter += 4;
				System.out.println(" - a ");
			} else if (b[0]%13 > c[0]%13 && b[0]%13 > d[0]%13) {
				prenarejdane(b, a, c, d, bCounter, aCounter, cCounter, dCounter);
				if(a[0]==-1) {
					aCounter++;
					bCounter--;
				}
				if(c[0]==-1) {
					cCounter++;
					bCounter--;
				}
				if(d[0]==-1) {
					dCounter++;
					bCounter--;
				}
				bCounter += 4;
				System.out.println(" - b ");
			} else if (c[0]%13 > d[0]%13) {
				prenarejdane(c, b, a, d, cCounter, bCounter, aCounter, dCounter);
				if(a[0]==-1) {
					aCounter++;
					cCounter--;
				}
				if(b[0]==-1) {
					bCounter++;
					cCounter--;
				}
				if(d[0]==-1) {
					dCounter++;
					cCounter--;
				}
				cCounter += 4;
				System.out.println(" - c ");
			} else {
				prenarejdane(d, b, c, a, dCounter, bCounter, cCounter, aCounter);
				if(a[0]==-1) {
					aCounter++;
					dCounter--;
				}
				if(b[0]==-1) {
					bCounter++;
					dCounter--;
				}
				if(c[0]==-1) {
					cCounter++;
					dCounter--;
				}
				dCounter += 4;
				System.out.println(" - d ");
			}
			if(a[0]!=-1) aCounter -= 1;
			if(b[0]!=-1) bCounter -= 1;
			if(c[0]!=-1) cCounter -= 1;
			if(d[0]!=-1) dCounter -= 1;

		}
		if(aCounter==51) {
			System.out.println("\nPecheli a");
		}else if(bCounter==51) {
			System.out.println("\nPecheli b");
		}else if(cCounter==51) {
			System.out.println("\nPecheli c");
		}else System.out.println("\nPecheli d");
	}

	static void prenarejdane(int a[], int b[], int c[], int d[], int aCounter, int bCounter, int cCounter,
			int dCounter) {
		int aSave = a[0];
		int bSave = b[0];
		int cSave = c[0];
		int dSave = d[0];
		if(cSave%13>bSave%13&&cSave%13>dSave%13) {
			int help=bSave;
			bSave=cSave;
			cSave=help;
		}else if(dSave%13>bSave%13&&dSave%13>cSave%13) {
			int help=bSave;
			bSave=dSave;
			dSave=help;
		}
		if(dSave>cSave) {
			int help=cSave;
			cSave=dSave;
			dSave=help;
		}
		for (int i = 0; i < 51; i++) {
			a[i] = a[i + 1];
			b[i] = b[i + 1];
			c[i] = c[i + 1];
			d[i] = d[i + 1];
		}

		a[aCounter] = aSave;
		a[aCounter + 1] = bSave;
		a[aCounter + 2] = cSave;
		a[aCounter + 3] = dSave;

		System.out.print(" karti na pechelivshiq: ");
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}
}
