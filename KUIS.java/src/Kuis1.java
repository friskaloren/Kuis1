import java.util.Scanner; 

public class Kuis1 {
    public static void main(String[] args) throws Exception {
        int pilihan;
        int jumlahtf = 0;
        int norektujuan = 0;
        int reksusi = 213456;
        int rekbudi = 314865;
        int saldosusi = 1000000;
        int saldobudi = 0;
        String yn = "y";
        int idx = 0;
        int[] mutasi = new int[100];

        Scanner keyboard = new Scanner(System.in);
        do{
            System.out.println("Aplikasi Transfer Uang");
            System.out.println("----------------------");
			System.out.println("1. Transfer");
			System.out.println("2. Cek Mutasi Rekening");
			System.out.println("3. Keluar");
			System.out.print("Pilihan Anda (1/2/3): ");
			pilihan = keyboard.nextInt();
            if(pilihan==1){
                bersihkanlayar();
                System.out.println("Menu Transfer");
                System.out.println("-------------");
                System.out.println("Masukkan Nomor Rekening yang Dituju: ");
                norektujuan = keyboard.nextInt();
                while(true){
                    if(norektujuan==rekbudi){
                       do{
                           System.out.println("Masukkan Jumlah yang Ditransfer: ");
                           jumlahtf = keyboard.nextInt();
                           bersihkanlayar();
                           System.out.println("Transfer sebesar Rp." + jumlahtf + " ke Rekening a/n Budi");
                           if(jumlahtf > saldosusi){
                               System.out.println("Saldo Anda Tidak Mencukupi");
                           }
                           else{
                               System.out.println("Transfer Berhasil");
                           }
                       } 
                       while(jumlahtf > saldosusi);
                       saldobudi = saldobudi + jumlahtf;
                       saldosusi = saldosusi - jumlahtf;
                       mutasi[idx] = jumlahtf;
                       idx++;
                       break;
                    }
                    else{
                        System.out.println("Nomor Rekening Salah"); break;
                    }
                }                
            }
            else if(pilihan==2){
                bersihkanlayar();
                System.out.println("Cek Mutasi Rekening");
                System.out.println("Pemilik Rekening: Susi" + "\nNomor Rekening: " + reksusi);
                System.out.println("----------------------");
                for(int i=0; i<idx; i++){
                    System.out.println("Transfer Sebesar Rp." + mutasi[idx] + " ke rekening a/n Budi");
                }
                if(idx==0){
                    System.out.println("Belum Ada Transaksi");
                }
                System.out.println("Saldo Anda: " + saldosusi + "");
            }
            else if(pilihan==3) break;
            
            System.out.print("\nApakah Anda Ingin Kembali ke Menu Utama (y/n)?: ");
            yn = keyboard.next();
            bersihkanlayar();
        }while(yn.equalsIgnoreCase("y"));
        keyboard.close();
    }

    public static void bersihkanlayar(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
