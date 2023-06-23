import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EksporImporBarang {
    private static Queue<String> queue = new LinkedList<>();

    private static void tambahBarang(String barang) {
        queue.add(barang);
        System.out.println(barang + " telah ditambahkan ke antrian.");
    }

    private static void cariBarang(String barang) {
        if (queue.contains(barang)) {
            System.out.println(barang + " ditemukan dalam antrian.");
        } else {
            System.out.println(barang + " tidak ditemukan dalam antrian.");
        }
    }

    private static void hapusBarang(String barang) {
        if (queue.remove(barang)) {
            System.out.println(barang + " telah dihapus dari antrian.");
        } else {
            System.out.println(barang + " tidak ditemukan dalam antrian.");
        }
    }

    private static void tampilkanAntrian() {
        if (queue.isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Isi antrian:");
            for (String barang : queue) {
                System.out.println(barang);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pilihan;
        String barang;

        do {
            System.out.println("=== Sistem Ekspor Impor Barang ===");
            System.out.println("1. Tambah Barang ke Antrian");
            System.out.println("2. Cari Barang dalam Antrian");
            System.out.println("3. Hapus Barang dari Antrian");
            System.out.println("4. Tampilkan Antrian");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();

            scanner.nextLine(); // Membuang karakter newline

            switch (pilihan) {
                case 1:
                    System.out.println("Masukkan jumlah barang: ");
                    int count = scanner.nextInt(); 
                    
                    scanner.nextLine(); // Membersihkan baris kosong
            
                    for (int i = 0; i < count; i++) {
                        System.out.print("Masukkan nama barang yang ingin ditambahkan: ");
                        String barangString = scanner.nextLine();
                        queue.offer(barangString); // Menambahkan data ke antrian
                    }
                    System.out.println("Data berhasil disimpan ke antrian.");
                    break;
                case 2:
                    System.out.print("Masukkan nama barang yang ingin dicari: ");
                    String searchData = scanner.nextLine();
        
                    boolean found = false;
                    int index = 1;
        
                    for (String searchdata : queue) {
                        if (searchdata.equals(searchData)) {
                            System.out.println("Data ditemukan pada posisi " + index + " dalam antrian.");
                            found = true;
                            break;
                        }
                        index++;
                    }
            
                    if (!found) {
                        System.out.println("Data tidak ditemukan dalam antrian.");
                    }
                    break;
                case 3:
                    System.out.print("Masukkan nama barang yang ingin dihapus: ");
                    barang = scanner.nextLine();
                    hapusBarang(barang);
                    break;
                case 4:
                    tampilkanAntrian();
                    break;
                case 0:
                    System.out.println("Terima kasih. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
            System.out.println();
        } while (pilihan != 0);
    }
}
