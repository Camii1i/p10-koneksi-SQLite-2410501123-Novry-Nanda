# AkademikApp

Aplikasi akademik sederhana berbasis Android (Kotlin) yang dikembangkan sebagai bagian dari praktikum **Mobile Programming**. Project ini mendemonstrasikan penggunaan **RecyclerView** untuk menampilkan daftar menu layanan akademik mahasiswa dalam tiga mode tampilan: **List**, **Grid**, dan **Card**.

## Fitur

- Dashboard Mahasiswa berisi daftar menu layanan akademik (Profil, Jadwal Kuliah, Nilai Akademik, KRS, Presensi, Tagihan)
- Tiga mode tampilan RecyclerView yang dapat dipilih secara dinamis melalui RadioGroup:
  - **List** — tampilan satu kolom dengan judul dan deskripsi
  - **Grid** — tampilan dua kolom dengan ikon di bagian atas
  - **Card** — tampilan satu kolom dengan ikon di sisi kiri
- Aksi klik pada setiap item menampilkan Toast berisi nama menu yang dipilih

## Teknologi

- Kotlin
- Android Jetpack: RecyclerView, Fragment, ViewBinding
- Material Components for Android

## Struktur Project

```
app/src/main/java/com/app/akademikapp/
├── data/model/
│   └── MenuAkademik.kt          # Model data menu akademik
├── utils/
│   └── MenuLayoutMode.kt         # Enum mode tampilan (LIST, GRID, CARD)
├── ui/adapter/
│   ├── MenuAkademikListAdapter.kt
│   ├── MenuAkademikGridAdapter.kt
│   └── MenuAkademikCardAdapter.kt
├── ui/main/
│   └── MahasiswaFragment.kt      # Fragment dashboard mahasiswa
└── MainActivity.kt

app/src/main/res/layout/
├── activity_main.xml
├── fragment_mahasiswa.xml
├── item_menu_akademik_list.xml
├── item_menu_akademik_grid.xml
└── item_menu_akademik_card.xml
```

## Cara Menjalankan

1. Clone repository ini:
   ```bash
   git clone https://github.com/Camii1i/P9-Mobile-RecyclerView-Mode-Grid-dan-Card-2410501123-Novry-Nanda
   ```
2. Buka project menggunakan **Android Studio** (versi terbaru direkomendasikan).
3. Tunggu proses Gradle sync selesai.
4. Jalankan aplikasi pada emulator atau perangkat fisik dengan menekan tombol **Run** ▶️.

### Requirement

- Android Studio dengan AGP yang kompatibel
- `compileSdk` 36, `minSdk` 24
- ViewBinding diaktifkan (`buildFeatures.viewBinding = true`)

## Konsep yang Diterapkan

- **RecyclerView** — menampilkan data dalam jumlah besar secara efisien dengan mekanisme recycling view
- **Adapter & ViewHolder** — menghubungkan data dengan tampilan serta mengoptimalkan performa scrolling
- **LayoutManager** — `LinearLayoutManager` untuk mode List/Card, `GridLayoutManager` untuk mode Grid
- **Dynamic Adapter Switching** — mengganti adapter dan layout manager berdasarkan pilihan mode tampilan pengguna

## Dokumentasi Praktikum

Project ini dikembangkan mengikuti modul praktikum:
- **Pertemuan 7** — RecyclerView Mode List
- **Pertemuan 9** — RecyclerView Mode Grid dan Card
