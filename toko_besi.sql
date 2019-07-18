-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 18 Jul 2019 pada 18.11
-- Versi server: 10.1.37-MariaDB
-- Versi PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `toko_besi`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_karyawan`
--

CREATE TABLE `data_karyawan` (
  `nip` varchar(20) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(40) NOT NULL,
  `no_hp` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `data_karyawan`
--

INSERT INTO `data_karyawan` (`nip`, `nama`, `alamat`, `no_hp`) VALUES
('1', 'bakwan', 'asd', 'asd');

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_kustomer`
--

CREATE TABLE `data_kustomer` (
  `kd_member` varchar(20) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `no_hp` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `data_kustomer`
--

INSERT INTO `data_kustomer` (`kd_member`, `nama`, `alamat`, `no_hp`) VALUES
('1', 'q', '1', 'd');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kategori`
--

CREATE TABLE `kategori` (
  `kode_kategori` varchar(20) NOT NULL,
  `nama_kategori` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kategori`
--

INSERT INTO `kategori` (`kode_kategori`, `nama_kategori`) VALUES
('001', 'BESI'),
('002', 'LOGAM'),
('003', 'KAWAT'),
('004', 'PLAT');

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('mat', '54321'),
('saleh', '54321');

-- --------------------------------------------------------

--
-- Struktur dari tabel `login_pemilik`
--

CREATE TABLE `login_pemilik` (
  `user` varchar(30) NOT NULL,
  `pass` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `login_pemilik`
--

INSERT INTO `login_pemilik` (`user`, `pass`) VALUES
('aguskotak', '12345'),
('irfan', '12345');

-- --------------------------------------------------------

--
-- Struktur dari tabel `master_produk`
--

CREATE TABLE `master_produk` (
  `kode_produk` varchar(20) NOT NULL,
  `kode_kategori` varchar(20) NOT NULL,
  `nama_produk` varchar(25) NOT NULL,
  `harga_beli` int(20) NOT NULL,
  `harga_jual` int(20) NOT NULL,
  `stok` int(20) NOT NULL,
  `Satuan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `master_produk`
--

INSERT INTO `master_produk` (`kode_produk`, `kode_kategori`, `nama_produk`, `harga_beli`, `harga_jual`, `stok`, `Satuan`) VALUES
('A001', '001', 'BESI ASSENTIAL', 80000, 100000, 50, 'Rp'),
('A002', '001', 'BESI BETON', 400000, 450000, 50, 'Rp'),
('A003', '001', 'BESI SIKU', 100000, 150000, 50, 'Rp'),
('A004', '001', 'BESI WIDE FLANGE', 300000, 350000, 50, 'Rp'),
('A005', '001', 'BESI H BEAM', 300000, 350000, 50, 'Rp'),
('A006', '001', 'BESI HOLLOW HITAM', 200000, 250000, 50, 'Rp'),
('A007', '001', 'BESI HOLLOW GALVALUM', 200000, 250000, 50, 'Rp'),
('A008', '002', 'EXPANKDED METAL', 40000, 50000, 60, 'Rp'),
('A009', '003', 'KAWAT BRONJONG', 60000, 80000, 60, 'Rp'),
('A010', '003', 'KAWAT LOKET', 60000, 80000, 60, 'Rp'),
('A011', '003', 'KAWAT PAGAR BRC', 80000, 90000, 60, 'Rp'),
('A012', '004', 'PLAT BESI', 90000, 100000, 65, 'Rp'),
('A013', '004', 'PLAT ALUMUNIUM', 80000, 90000, 65, 'Rp'),
('A014', '004', 'PLAT BAJA', 100000, 110000, 65, 'Rp'),
('A015', '004', 'PLAT HITAM ESER', 100000, 110000, 65, 'Rp'),
('A016', '004', 'PLAT KAPAL', 90000, 100000, 65, 'Rp'),
('A017', '004', 'PLAT SENG', 40000, 50000, 65, 'Rp'),
('A018', '004', 'PLAT GALVALUM', 40000, 50000, 65, 'Rp'),
('A019', '004', 'PLAT SENG GELOMBANG', 40000, 50000, 65, 'Rp');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `nomor_penjualan` varchar(20) NOT NULL,
  `kode_produk` varchar(20) NOT NULL,
  `nama_produk` varchar(25) NOT NULL,
  `harga_jual` int(20) NOT NULL,
  `jumlah` int(20) NOT NULL,
  `total` int(20) NOT NULL,
  `bayar` int(20) NOT NULL,
  `kembali` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`nomor_penjualan`, `kode_produk`, `nama_produk`, `harga_jual`, `jumlah`, `total`, `bayar`, `kembali`) VALUES
('000012', 'A001', 'BESI ASSENTIAL', 100000, 3, 300000, 4000000, 3700000),
('011', 'A001', 'BESI ASSENTIAL', 100000, 2, 200000, 300000, 100000),
('111', 'A002', 'BESI BETON', 450000, 2, 900000, 10000000, 9100000),
('1111', 'A003', 'BESI SIKU', 150000, 3, 900000, 500000, -400000),
('657676', 'A001', 'BESI ASSENTIAL', 100000, 2, 200000, 300000, 100000);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `data_karyawan`
--
ALTER TABLE `data_karyawan`
  ADD PRIMARY KEY (`nip`);

--
-- Indeks untuk tabel `data_kustomer`
--
ALTER TABLE `data_kustomer`
  ADD PRIMARY KEY (`kd_member`);

--
-- Indeks untuk tabel `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`kode_kategori`);

--
-- Indeks untuk tabel `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`username`);

--
-- Indeks untuk tabel `login_pemilik`
--
ALTER TABLE `login_pemilik`
  ADD PRIMARY KEY (`user`);

--
-- Indeks untuk tabel `master_produk`
--
ALTER TABLE `master_produk`
  ADD PRIMARY KEY (`kode_produk`),
  ADD KEY `kode_kategori` (`kode_kategori`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`nomor_penjualan`),
  ADD KEY `kode_produk` (`kode_produk`,`nama_produk`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `master_produk`
--
ALTER TABLE `master_produk`
  ADD CONSTRAINT `master_produk_ibfk_1` FOREIGN KEY (`kode_kategori`) REFERENCES `kategori` (`kode_kategori`);

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`kode_produk`) REFERENCES `master_produk` (`kode_produk`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
