import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Kiem thu hop den cho BikeRental.tinhPhi()
 *
 * PHAN 1 - Bang quyet dinh (16 ca):
 * PHAN 2 - Kiem thu gia tri bien don (27 ca)
 *
 */
class BikeRentalTest {

    static final double DELTA = 0.001;
    // PHAN 1 — BANG QUYET DINH (16 ca)
    @Nested
    @DisplayName("Phan 1 — Bang quyet dinh")
    class DecisionTable {

        @Test @DisplayName("R1 | sinhvien + thuong + H=-1 -> -1")
        void r01() { assertEquals(-1.0, BikeRental.tinhPhi("sinhvien", -1, "thuong")); }

        @Test @DisplayName("R2 | sinhvien + thuong + H=2 -> 8000")
        void r02() {
            assertEquals(0, BikeRental.tinhPhi("sinhvien", 0, "thuong"));
        }
        @Test @DisplayName("R3 (*) | sinhvien + thuong + H=6 -> 27000 [FAIL]")
        void r03() {
            assertEquals(23200.0, BikeRental.tinhPhi("sinhvien", 6, "thuong"));
        }

        @Test @DisplayName("R4 | sinhvien + thuong + H=12 -> 43200")
        void r04() {
            assertEquals(43200.0, BikeRental.tinhPhi("sinhvien", 12, "thuong"));
        }

        @Test @DisplayName("R5 | sinhvien + cuoituan + H=25 -> -1")
        void r05() { assertEquals(-1.0, BikeRental.tinhPhi("sinhvien", 25, "cuoituan")); }

        @Test @DisplayName("R6 | sinhvien + cuoituan + H=2 -> 11200")
        void r06() {
            assertEquals(11200.0, BikeRental.tinhPhi("sinhvien", 2, "cuoituan"));
        }

        @Test @DisplayName("R7 | sinhvien + cuoituan + H=6 -> 32480")
        void r07() {
            assertEquals(32480.0, BikeRental.tinhPhi("sinhvien", 6, "cuoituan"));
        }

        @Test @DisplayName("R8 | sinhvien + cuoituan + H=12 -> 60480")
        void r08() {
            assertEquals(60480.0, BikeRental.tinhPhi("sinhvien", 12, "cuoituan"));
        }

        @Test @DisplayName("R9 | thuong + thuong + H=0 -> -1")
        void r09() { assertEquals(0, BikeRental.tinhPhi("thuong", 0, "thuong")); }

        @Test @DisplayName("R10 | thuong + thuong + H=2 -> 10000")
        void r10() {
            assertEquals(10000.0, BikeRental.tinhPhi("thuong", 2, "thuong"));
        }

        @Test @DisplayName("R11 | thuong + thuong + H=6 -> 29000")
        void r11() {
            assertEquals(29000.0, BikeRental.tinhPhi("thuong", 6, "thuong"));
        }

        @Test @DisplayName("R12 (*) | thuong + thuong + H=12 -> 50000 [FAIL]")
        void r12() {
            assertEquals(54000.0, BikeRental.tinhPhi("thuong", 12, "thuong"));
        }

        @Test @DisplayName("R13 | thuong + cuoituan + H=30 -> -1")
        void r13() { assertEquals(-1.0, BikeRental.tinhPhi("thuong", 30, "cuoituan")); }

        @Test @DisplayName("R14 | thuong + cuoituan + H=2 -> 14000")
        void r14() {
            assertEquals(14000.0, BikeRental.tinhPhi("thuong", 2, "cuoituan"));
        }

        @Test @DisplayName("R15 | thuong + cuoituan + H=6 -> 40600")
        void r15() {
            assertEquals(40600.0, BikeRental.tinhPhi("thuong", 6, "cuoituan"));
        }

        @Test @DisplayName("R16 | thuong + cuoituan + H=12 -> 75600")
        void r16() {
            assertEquals(75600.0, BikeRental.tinhPhi("thuong", 12, "cuoituan"));
        }
    }
    // PHAN 2 — KIEM THU GIA TRI BIEN DON (27 ca)

    @Nested
    @DisplayName("Phan 2 — Kiem thu gia tri bien don")
    class BoundaryValue {

        // ── Nhom A: Bien soGio (co dinh: thuong / thuong) ────────────

        @Test @DisplayName("BV-01 | min1-1: H=-0.1 -> -1")
        void bv01() { assertEquals(-1.0, BikeRental.tinhPhi("thuong", -0.1, "thuong")); }

        @Test @DisplayName("BV-02 | min1: H=0 -> -1")
        void bv02() { assertEquals(0, BikeRental.tinhPhi("thuong", 0.0, "thuong")); }

        @Test @DisplayName("BV-03 | min1+1: H=0.1 -> 500")
        void bv03() {
            assertEquals(500.0, BikeRental.tinhPhi("thuong", 0.1, "thuong"), DELTA);
        }

        @Test @DisplayName("BV-04 | nom1: H=2 -> 10000")
        void bv04() {
            assertEquals(10000.0, BikeRental.tinhPhi("thuong", 2, "thuong"));
        }

        @Test @DisplayName("BV-05 | max1-1: H=3.9 -> 19500")
        void bv05() {
            assertEquals(19500.0, BikeRental.tinhPhi("thuong", 3.9, "thuong"), DELTA);
        }

        @Test @DisplayName("BV-06 | max1: H=4.0 -> 20000")
        void bv06() {
            assertEquals(20000.0, BikeRental.tinhPhi("thuong", 4.0, "thuong"));
        }
        @Test @DisplayName("BV-07 (*) | max1+1: H=4.1 -> 21000 [FAIL]")
        void bv07() {
            assertEquals(20450, BikeRental.tinhPhi("thuong", 4.1, "thuong"), DELTA);
        }

        @Test @DisplayName("BV-08 | nom2: H=6 -> 29000")
        void bv08() {
            assertEquals(29000.0, BikeRental.tinhPhi("thuong", 6, "thuong"));
        }

        @Test @DisplayName("BV-09 | max2-1: H=7.9 -> 37550")
        void bv09() {
            assertEquals(37550.0, BikeRental.tinhPhi("thuong", 7.9, "thuong"), DELTA);
        }

        @Test @DisplayName("BV-10 | max2: H=8.0 -> 38000")
        void bv10() {
            assertEquals(38000.0, BikeRental.tinhPhi("thuong", 8.0, "thuong"));
        }

        @Test @DisplayName("BV-11 | max2+1: H=8.1 -> 38400")
        void bv11() {
            assertEquals(38400.0, BikeRental.tinhPhi("thuong", 8.1, "thuong"), DELTA);
        }

        @Test @DisplayName("BV-12 | nom3: H=16 -> 70000")
        void bv12() {

            assertEquals(70000.0, BikeRental.tinhPhi("thuong", 16, "thuong"));
        }

        @Test @DisplayName("BV-13 | max3-1: H=23.9 -> 101600")
        void bv13() {

            assertEquals(101600.0, BikeRental.tinhPhi("thuong", 23.9, "thuong"), DELTA);
        }

        @Test @DisplayName("BV-14 (*) | max3: H=24.0 -> 105000 [FAIL]")
        void bv14() {
            assertEquals(102000, BikeRental.tinhPhi("thuong", 24.0, "thuong"));
        }

        @Test @DisplayName("BV-15 | max3+1: H=24.1 -> -1")
        void bv15() { assertEquals(-1.0, BikeRental.tinhPhi("thuong", 24.1, "thuong")); }

        // ── Nhom B: Bien loaiThe (co dinh: loaiNgay=thuong) ──────────

        @Test @DisplayName("BV-16 | loaiThe=thuong   + nom1=2  -> 10000")
        void bv16() { assertEquals(10000.0, BikeRental.tinhPhi("thuong",   2,  "thuong")); }

        @Test @DisplayName("BV-17 | loaiThe=sinhvien + nom1=2  -> 8000")
        void bv17() { assertEquals(8000.0,  BikeRental.tinhPhi("sinhvien", 2,  "thuong")); }

        @Test @DisplayName("BV-18 | loaiThe=thuong   + nom2=6  -> 29000")
        void bv18() { assertEquals(29000.0, BikeRental.tinhPhi("thuong",   6,  "thuong")); }

        @Test @DisplayName("BV-19 | loaiThe=sinhvien + nom2=6  -> 23200")
        void bv19() { assertEquals(23200.0, BikeRental.tinhPhi("sinhvien", 6,  "thuong")); }

        @Test @DisplayName("BV-20 | loaiThe=thuong   + nom3=16 -> 70000")
        void bv20() { assertEquals(70000.0, BikeRental.tinhPhi("thuong",   16, "thuong")); }

        @Test @DisplayName("BV-21 | loaiThe=sinhvien + nom3=16 -> 56000")
        void bv21() {
            // 70000*0.8 = 56000
            assertEquals(56000.0, BikeRental.tinhPhi("sinhvien", 16, "thuong"));
        }

        // ── Nhom C: Bien loaiNgay (co dinh: loaiThe=thuong) ──────────

        @Test @DisplayName("BV-22 | loaiNgay=thuong   + nom1=2  -> 10000")
        void bv22() { assertEquals(10000.0,  BikeRental.tinhPhi("thuong", 2,  "thuong")); }

        @Test @DisplayName("BV-23 | loaiNgay=cuoituan + nom1=2  -> 14000")
        void bv23() { assertEquals(14000.0,  BikeRental.tinhPhi("thuong", 2,  "cuoituan")); }

        @Test @DisplayName("BV-24 | loaiNgay=thuong   + nom2=6  -> 29000")
        void bv24() { assertEquals(29000.0,  BikeRental.tinhPhi("thuong", 6,  "thuong")); }

        @Test @DisplayName("BV-25 | loaiNgay=cuoituan + nom2=6  -> 40600")
        void bv25() { assertEquals(40600.0,  BikeRental.tinhPhi("thuong", 6,  "cuoituan")); }

        @Test @DisplayName("BV-26 | loaiNgay=thuong   + nom3=16 -> 70000")
        void bv26() { assertEquals(70000.0,  BikeRental.tinhPhi("thuong", 16, "thuong")); }

        @Test @DisplayName("BV-27 | loaiNgay=cuoituan + nom3=16 -> 98000")
        void bv27() {
            assertEquals(98000.0, BikeRental.tinhPhi("thuong", 16, "cuoituan"));
        }
    }
}