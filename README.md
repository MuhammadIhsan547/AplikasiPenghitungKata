# AplikasiPenghitungKata
 Tugas5 - Muhammad Ihsan - 2210010286

## 1. Deskripsi Program
Aplikasi ini digunakan untuk menghitung jumlah kata, karakter, kalimat, dan paragraf dalam teks yang dimasukkan oleh pengguna. Pengguna dapat memasukkan teks di area input yang disediakan, dan setelah itu, hasil perhitungan akan ditampilkan di label yang sesuai. Selain itu, aplikasi ini juga menyediakan fitur pencarian untuk menghitung berapa kali sebuah kata muncul dalam teks dan kemampuan untuk menyimpan teks beserta hasil perhitungan ke dalam file.

## 2. Komponen GUI:
- **JFrame**: Sebagai container utama.
- **JPanel**: Menjadi panel untuk menyusun elemen-elemen GUI.
- **JLabel**: Untuk menampilkan hasil perhitungan jumlah kata, karakter, kalimat, paragraf.
- **JTextArea**: Untuk input teks yang akan dihitung.
- **JScrollPane**: Membungkus JTextArea untuk memungkinkan scroll pada teks.
- **JButton**: 
    - "Hitung Kata": Untuk memicu perhitungan kata, karakter, kalimat, dan paragraf.
    - "Cari": Untuk mencari dan menghitung kemunculan kata tertentu.
    - "Simpan File": Untuk menyimpan teks dan hasil perhitungan ke dalam file.
    - "Keluar": Untuk menutup aplikasi.
    - "Hapus": Untuk menghapus teks yang dimasukkan dan mereset hasil perhitungan.
- **JTextField**: Untuk input kata yang ingin dicari dalam teks.

### Tombol "Hapus":
```java
private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {                                         
    btnHapus.addActionListener((ActionEvent e) -> {
        textAreaInputKata.setText("");  // Mengosongkan JTextArea
        // Mereset label hasil perhitungan
        jumlahkata.setText("0");
        jumlahkarakter.setText("0");
        jumlahkalimat.setText("0");
        jumlahparagraf.setText("0");
        jumlahkemunculankata.setText("0");
        TextFieldCari.setText(""); // Mengosongkan JTextField untuk pencarian kata
    });
}
```
Tombol ini berfungsi untuk mengosongkan teks di JTextArea dan mereset label hasil perhitungan ke nilai default.

## 3. Logika Program:
Aplikasi ini menggunakan manipulasi string dan ekspresi reguler untuk menghitung jumlah kata, karakter, kalimat, dan paragraf dalam teks yang dimasukkan.

### Menghitung Jumlah Kata, Karakter, Kalimat, dan Paragraf:
```java
private void MethodHitung() {
    String isiTeks = Target.getText();

    // Menghitung jumlah karakter
    int totalKarakter = isiTeks.length();

    // Menghitung jumlah kata
    String[] kataArray = isiTeks.trim().split("\\s+");
    int totalKata = kataArray.length;

    // Menghitung jumlah kalimat
    String[] kalimatArray = isiTeks.split("[.!?]+");
    int totalKalimat = kalimatArray.length;

    // Menghitung jumlah paragraf
    String[] paragrafArray = isiTeks.split("\\n+");
    int totalParagraf = paragrafArray.length;

    // Tampilkan hasil hitung pada Label
    LabelTotalKata.setText("Total Kata: " + totalKata);
    LabelTotalKarakter.setText("Total Karakter: " + totalKarakter);
    LabelTotalKalimat.setText("Total Kalimat: " + totalKalimat);
    LabelTotalParagraf.setText("Total Paragraf: " + totalParagraf);
}
```
Kode ini menghitung jumlah kata, karakter, kalimat, dan paragraf berdasarkan pemisah tertentu menggunakan ekspresi reguler.

### Pencarian Kata:
```java
private void TombolCariActionPerformed(java.awt.event.ActionEvent evt) {                                           
    String carikata = CariKata.getText().trim();
    String harusteks = Target.getText();

    if (carikata.isEmpty() || harusteks.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Masukkan kata yang ingin dicari.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Menghitung jumlah kemunculan kata
    String[] kataArray = harusteks.split("\\s+");
    int totalmuncul = 0;
    for (String kata : kataArray) {
        if (kata.equalsIgnoreCase(carikata)) {
            totalmuncul++;
        }
    }

    // Menampilkan hasil
    JOptionPane.showMessageDialog(this, "Kata '" + carikata + "': " + totalmuncul);
}
```
Kode ini menghitung jumlah kemunculan kata yang dicari dalam teks.

### Menyimpan Hasil ke File:
```java
private void TombolSimpanActionPerformed(java.awt.event.ActionEvent evt) {                                             
    // Cek apakah Target Area kosong
    if (Target.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Teks tidak boleh kosong. Masukkan teks terlebih dahulu.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Batalkan proses penyimpanan
    }

    JFileChooser fileChooser = new JFileChooser();
    int userSelection = fileChooser.showSaveDialog(this);

    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File fileToSave = fileChooser.getSelectedFile();
        try (PrintWriter writer = new PrintWriter(fileToSave)) {
            // Menulis isi teks
            writer.println("Isi Teks:");
            writer.println(Target.getText());

            // Menulis hasil perhitungan
            writer.println("\nHasil Perhitungan:");
            writer.println(LabelTotalKata.getText());
            writer.println(LabelTotalKarakter.getText());
            writer.println(LabelTotalKalimat.getText());
            writer.println(LabelTotalParagraf.getText());

            JOptionPane.showMessageDialog(this, "File berhasil disimpan.", "Simpan Berhasil", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
```
Kode ini memungkinkan pengguna untuk menyimpan teks beserta hasil perhitungan dalam sebuah file.

## 4. Events:
- **ActionListener** pada tombol "Hitung" untuk memanggil metode `MethodHitung()` yang menghitung jumlah kata, karakter, kalimat, dan paragraf.
- **ActionListener** pada tombol "Cari" untuk menghitung jumlah kemunculan kata dalam teks.
- **ActionListener** pada tombol "Simpan" untuk menyimpan teks dan hasil perhitungan ke file.

### Event ActionListener pada Tombol "Hitung":
```java
private void TombolHitungActionPerformed(java.awt.event.ActionEvent evt) {                                             
    MethodHitung();
}
```
Tombol "Hitung" memicu perhitungan jumlah kata, karakter, kalimat, dan paragraf.

## 5. Variasi:
- **Fitur Menghitung Jumlah Kalimat dan Paragraf**:
    - Kalimat dihitung menggunakan pemisah seperti titik, tanda seru, dan tanda tanya.
    - Paragraf dihitung dengan pemisah garis baru.
  
- **Fitur Pencarian Kata**:
    - Aplikasi menghitung dan menampilkan jumlah kemunculan kata yang dicari dalam teks.
  
- **Fitur Penyimpanan Hasil**:
    - Pengguna dapat menyimpan teks dan hasil perhitungan ke dalam file.

## 6. Contoh Gambar Project Setelah di Run

![Tugas5](https://github.com/user-attachments/assets/0880d809-053d-4c0b-963b-0f0daba3765f)


## 7. Indikator Penilaian:

| No  | Komponen         |  Persentase  |
| :-: | --------------   |   :-----:    |
|  1  | Komponen GUI     |    10    |
|  2  | Logika Program   |    20    |
|  3  |  Events          |    10    |
|  4  | Kesesuaian UI    |    20    |
|  5  | Memenuhi Variasi |    40    |
|     | TOTAL        | 100 |

## Pembuat
Nama  : Muhammad Ihsan   
NPM   : 2210010286
Kelas : 5A Ti Reg Pagi BJM
