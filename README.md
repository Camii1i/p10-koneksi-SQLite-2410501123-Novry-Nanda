# AkademikApp

Aplikasi akademik sederhana berbasis Android (Kotlin) yang dikembangkan sebagai bagian dari praktikum **Mobile Programming**. Project ini mendemonstrasikan penggunaan **RecyclerView** (mode List, Grid, dan Card), serta integrasi **database lokal SQLite** untuk pengelolaan data mahasiswa.

## Fitur

- **Halaman Pilih Peran (Home)** — titik masuk aplikasi, pengguna memilih masuk sebagai Mahasiswa atau Admin
- **Dashboard Mahasiswa** berisi daftar menu layanan akademik (Profil, Jadwal Kuliah, Nilai Akademik, KRS, Presensi, Tagihan)
  - Tiga mode tampilan RecyclerView yang dapat dipilih secara dinamis melalui RadioGroup:
    - **List** — tampilan satu kolom dengan judul dan deskripsi
    - **Grid** — tampilan dua kolom dengan ikon di bagian atas
    - **Card** — tampilan satu kolom dengan ikon di sisi kiri
  - Aksi klik pada setiap item menampilkan Toast berisi nama menu yang dipilih
- **Dashboard Admin** sebagai pusat pengelolaan data akademik
  - Kelola Data Mahasiswa (aktif)
  - Kelola Jadwal Kuliah (segera hadir)
  - Kelola Nilai Mahasiswa (segera hadir)
- **Pengelolaan Data Mahasiswa berbasis SQLite (lokal)**
  - Tambah data mahasiswa (NIM, nama, prodi, semester, email) melalui form
  - Tampilkan seluruh data mahasiswa dalam RecyclerView
  - Hapus data mahasiswa
  - Validasi input dan NIM unik

## Tools

- Kotlin
- Android Jetpack: RecyclerView, Fragment, ViewBinding
- SQLite (`SQLiteOpenHelper`) sebagai database lokal
- Material Components for Android

## Struktur Project

\```
app/src/main/java/com/app/akademikapp/
├── data/local/
│   └── MahasiswaDbHelper.kt      # Helper SQLite (CRUD data mahasiswa)
├── data/model/
│   ├── Mahasiswa.kt              # Model data mahasiswa
│   └── MenuAkademik.kt           # Model data menu akademik
├── MenuLayoutMode.kt             # Enum mode tampilan (LIST, GRID, CARD)
├── ui/adapter/
│   ├── MahasiswaAdapter.kt
│   ├── MenuAkademikListAdapter.kt
│   ├── MenuAkademikGridAdapter.kt
│   └── MenuAkademikCardAdapter.kt
├── ui/main/
│   ├── HomeFragment.kt           # Halaman pilih peran (Mahasiswa / Admin)
│   ├── MahasiswaFragment.kt      # Dashboard mahasiswa
│   ├── AdminFragment.kt          # Dashboard admin
│   ├── DataMahasiswaFragment.kt  # Tampilkan & hapus data mahasiswa (SQLite)
│   └── TambahMahasiswaFragment.kt# Form tambah data mahasiswa (SQLite)
└── MainActivity.kt

app/src/main/res/layout/
├── activity_main.xml
├── fragment_home.xml
├── fragment_mahasiswa.xml
├── fragment_admin.xml
├── fragment_data_mahasiswa.xml
├── fragment_tambah_mahasiswa.xml
├── item_mahasiswa.xml
├── item_menu_akademik_list.xml
├── item_menu_akademik_grid.xml
└── item_menu_akademik_card.xml
\```

## Cara Menjalankan

1. Clone repository ini:
   \```bash
   git clone https://github.com/Camii1i/P9-Mobile-RecyclerView-Mode-Grid-dan-Card-2410501123-Novry-Nanda
   \```
2. Buka project menggunakan **Android Studio** (versi terbaru direkomendasikan).
3. Tunggu proses Gradle sync selesai.
4. Jalankan aplikasi pada emulator atau perangkat fisik dengan menekan tombol **Run** ▶️.
5. Aplikasi akan terbuka pada halaman pilih peran. Pilih **Masuk sebagai Mahasiswa** untuk melihat dashboard menu akademik, atau **Masuk sebagai Admin** untuk mengelola data mahasiswa (tambah, lihat, hapus).

### Requirement

- Android Studio dengan AGP yang kompatibel
- `compileSdk` 36, `minSdk` 24
- ViewBinding diaktifkan (`buildFeatures.viewBinding = true`)

## Konsep yang Diterapkan

- **RecyclerView** — menampilkan data dalam jumlah besar secara efisien dengan mekanisme recycling view
- **Adapter & ViewHolder** — menghubungkan data dengan tampilan serta mengoptimalkan performa scrolling
- **LayoutManager** — `LinearLayoutManager` untuk mode List/Card, `GridLayoutManager` untuk mode Grid
- **Dynamic Adapter Switching** — mengganti adapter dan layout manager berdasarkan pilihan mode tampilan pengguna
- **Fragment Navigation** — perpindahan antar halaman menggunakan `FragmentManager` dan back stack
- **SQLite (`SQLiteOpenHelper`)** — penyimpanan data lokal di perangkat tanpa memerlukan koneksi internet maupun server
- **CRUD (Create, Read, Delete)** — proses tambah, tampil, dan hapus data mahasiswa pada database lokal
