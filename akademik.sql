-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 20, 2018 at 01:19 PM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `akademik`
--

-- --------------------------------------------------------

--
-- Table structure for table `dosen`
--

CREATE TABLE `dosen` (
  `nip` int(20) NOT NULL,
  `nama_dosen` varchar(100) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `no_tlp` varchar(20) NOT NULL,
  `gelar` varchar(20) NOT NULL,
  `jk` enum('L','P') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dosen`
--

INSERT INTO `dosen` (`nip`, `nama_dosen`, `alamat`, `no_tlp`, `gelar`, `jk`) VALUES
(5200001, 'Andi Mashdarul Khair', 'Jl.Perumahan Daya', '0851002514001', 'S.Kom.,MT', 'L'),
(5200002, 'Sigit', 'Jl.Perumahan Daya', '085221089750', 'S.Kom.,MT', 'L'),
(5200010, 'Wahyuni', 'Jl.Lanraki', '087458012530', 'S.Kom.,MT', 'P'),
(5200011, 'Atika Muthia', 'Jl.Perumahan Antang', '081234001200', 'S.Kom.,MT', 'P'),
(5200012, 'Muh Sahid', 'Jl.Perumahan Khatulistiwa', '081201020100', 'S.Kom.,MT', 'L'),
(5200050, 'Triskawani', 'Perumahan Dosen', '081230110201', 'S.Kom.,MT', 'P'),
(5200051, 'Andre Tialen', 'Jl.Pettaranu', '082102340052', 'S.Kom.,MT', 'L'),
(5200100, 'Rifaldi', 'Jl.Perumahan Dosen', '082153210005', 'S.Kom.,MT', 'L'),
(5200101, 'Suciyati', 'Jl.Perumahan Dosen', '081355238320', 'S.Kom.,MT', 'P'),
(5200111, 'Anggi', 'Jl.Perintis Kemerdekaan ', '0879802001001', 'S.Kom.,MT', 'P');

-- --------------------------------------------------------

--
-- Table structure for table `input_sks`
--

CREATE TABLE `input_sks` (
  `stb` int(6) NOT NULL,
  `kode_matkul` varchar(6) NOT NULL,
  `jumlah_sks` int(20) NOT NULL,
  `nip` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `input_sks`
--

INSERT INTO `input_sks` (`stb`, `kode_matkul`, `jumlah_sks`, `nip`) VALUES
(152194, 'E212-T', 2, 5200010),
(152194, 'H312-T', 2, 5200050),
(152194, 'P144-T', 4, 5200001),
(152194, 'P362-T', 2, 5200051),
(152194, 'P364-T', 4, 5200051),
(152194, 'P474-T', 4, 5200001),
(152199, 'A312-T', 2, 5200100),
(152199, 'B102-T', 2, 5200101),
(152199, 'A102-T', 2, 5200111),
(152199, 'E212-T', 2, 5200010),
(152199, 'K502-T', 2, 5200010),
(152199, 'R712-T', 2, 5200001),
(152199, 'P364-T', 4, 5200051),
(152199, 'P474-T', 4, 5200001),
(152201, 'R712-T', 2, 5200001),
(152201, 'P474-T', 4, 5200001),
(152201, 'P364-T', 4, 5200051),
(152201, 'P362-T', 2, 5200051),
(152201, 'P144-T', 4, 5200001),
(152201, 'H312-T', 2, 5200050),
(152201, 'K502-T', 2, 5200010),
(152201, 'A312-T', 2, 5200100),
(152194, 'R712-T', 2, 5200001);

-- --------------------------------------------------------

--
-- Table structure for table `jurusan`
--

CREATE TABLE `jurusan` (
  `kode_jurusan` int(2) NOT NULL,
  `nama_jurusan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jurusan`
--

INSERT INTO `jurusan` (`kode_jurusan`, `nama_jurusan`) VALUES
(1, 'Sistem Informasi'),
(2, 'Teknik Informatika'),
(3, 'Manajemen Informatika');

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `stb` int(6) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `jk` enum('L','P') NOT NULL,
  `tempat_lahir` varchar(20) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `agama` varchar(11) NOT NULL,
  `kode_jurusan` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`stb`, `nama`, `alamat`, `jk`, `tempat_lahir`, `tgl_lahir`, `agama`, `kode_jurusan`) VALUES
(152194, 'Radiyan', 'Jl.Paccerakang', 'L', 'Ujung Pandang', '1997-12-14', 'Islam', 2),
(152199, 'Fikri ', 'Jl. Perintis Kemerdekaan', 'L', 'Wajo', '1997-07-07', 'Islam', 1),
(152201, 'Indri Andini', 'Jl.Perumahan Villa Mutiara', 'P', 'Ujung Pandang', '1997-06-14', 'Islam', 2),
(152204, 'Andri Frans ', 'Jl.Perumahan BTP', 'L', 'Toraja', '1997-10-13', 'Kristen', 2),
(152227, 'Mutiara', 'Jl.Perintis Kemerdekaan KM.7', 'P', 'Toraja', '1998-07-12', 'Kristen', 1);

-- --------------------------------------------------------

--
-- Table structure for table `matkul`
--

CREATE TABLE `matkul` (
  `kode_matkul` varchar(6) NOT NULL,
  `nama_matkul` varchar(50) NOT NULL,
  `sks` int(5) NOT NULL,
  `nip` int(20) NOT NULL,
  `hari` varchar(20) NOT NULL,
  `jam` varchar(20) NOT NULL,
  `ruangan` varchar(20) NOT NULL,
  `kelas` varchar(20) NOT NULL,
  `semester` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `matkul`
--

INSERT INTO `matkul` (`kode_matkul`, `nama_matkul`, `sks`, `nip`, `hari`, `jam`, `ruangan`, `kelas`, `semester`) VALUES
('A102-T', 'Kalkulus I', 2, 5200111, 'Rabu', '07.30-09.20', 'B102', '1KAA-B', '1'),
('A312-T', 'Metode Numerik', 2, 5200100, 'Rabu', '09.20-11.10', 'A101', '3MNO-A', '3'),
('B102-T', 'Bhs Inggris I', 2, 5200101, 'Kamis', '07.30-09.10', 'A105', '1BIA-A', '1'),
('E212-T', 'Elektronika Analog', 2, 5200010, 'Rabu', '07.30-09.10', 'A203', '1EAP-A', '1'),
('H312-T', 'Hukum dan Komputer', 2, 5200050, 'Kamis', '11.10-12.10', 'B201', '2HDK-A', '2'),
('K502-T', 'Organisasi dan Arsitektur Komputer', 2, 5200010, 'Selasa', '09.20-11.00', 'B105', '3TOAK-F', '3'),
('P144-T', 'Algoritma dan Pemrograman', 4, 5200001, 'Senin', '07.30-09.10', 'A101', '1ADP-B', '1'),
('P362-T', 'Prak Pemrograman Web', 2, 5200051, 'Jumat', '07.30-09.10', '305', '3TLW-A', '3'),
('P364-T', 'Pemrograman Web', 4, 5200051, 'Selasa', '09.20-11.10', 'B101', '3TWEB-K', '3'),
('P474-T', 'Pemrograman Visual Net', 4, 5200001, 'Senin', '1.40-3.20', 'A103', '4PVN-A', '4'),
('R712-T', 'Analisis Algoritma', 2, 5200001, 'Senin', '11.10-12.00', 'A108', '5AGT-C', '5');

-- --------------------------------------------------------

--
-- Table structure for table `rancangan_studi`
--

CREATE TABLE `rancangan_studi` (
  `stb` int(6) NOT NULL,
  `kode_matkul` varchar(20) NOT NULL,
  `nilai` varchar(20) NOT NULL,
  `thn_ajar` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rancangan_studi`
--

INSERT INTO `rancangan_studi` (`stb`, `kode_matkul`, `nilai`, `thn_ajar`) VALUES
(152194, 'A312-T', 'A', '2016/2017'),
(152199, 'E212-T', 'A', '2016/2017'),
(152194, 'H312-T', 'B', '2016/2017'),
(152201, 'K502-T', 'A', '2016/2017'),
(152194, 'P144-T', 'C', '2016/2017');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dosen`
--
ALTER TABLE `dosen`
  ADD PRIMARY KEY (`nip`);

--
-- Indexes for table `jurusan`
--
ALTER TABLE `jurusan`
  ADD PRIMARY KEY (`kode_jurusan`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`stb`);

--
-- Indexes for table `matkul`
--
ALTER TABLE `matkul`
  ADD PRIMARY KEY (`kode_matkul`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
