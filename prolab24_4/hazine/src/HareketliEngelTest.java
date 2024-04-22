import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class HareketliEngel {
    int x;
    int y;
    int hizX;
    int hizY;
    int genislik;
    int yukseklik;

    public HareketliEngel(int x, int y, int hizX, int hizY, int genislik, int yukseklik) {
        this.x = x;
        this.y = y;
        this.hizX = hizX;
        this.hizY = hizY;
        this.genislik = genislik;
        this.yukseklik = yukseklik;
    }

    public void hareketEt() {
        // Engeli hareket ettir
        x += hizX;
        y += hizY;

        // Harita sınırlarını kontrol et
        if (x < 0 || x > 90) {
            hizX = -hizX;
        }

        if (y < 0 || y > 90) {
            hizY = -hizY;
        }
    }

    public boolean cakismiyorMu(HareketliEngel digerEngel) {
        // İki engel birbirine girmiyorsa true, aksi takdirde false döndür
        return (this.x + genislik <= digerEngel.x ||  // Sol kenar
                digerEngel.x + digerEngel.genislik <= this.x ||  // Sağ kenar
                this.y + yukseklik <= digerEngel.y ||  // Üst kenar
                digerEngel.y + digerEngel.yukseklik <= this.y);  // Alt kenar
    }

    public int getGenislik() {
        return genislik;
    }

    public int getYukseklik() {
        return yukseklik;
    }
}

class HaritaPaneli extends JPanel {
    private HareketliEngel kuş;
    private HareketliEngel arı;

    public HaritaPaneli() {
        kuş = new HareketliEngel(10, 10, 2, 2, 20, 20);
        arı = new HareketliEngel(70, 70, -2, -2, 20, 20);

        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kuş.hareketEt();
                arı.hareketEt();

                // Kuş ve arı birbirine girmiyorsa pozisyonlarını güncelle
                if (kuş.cakismiyorMu(arı)) {
                    repaint();
                }
            }
        });

        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        g.fillRect(kuş.x, kuş.y, kuş.getGenislik(), kuş.getYukseklik());

        g.setColor(Color.YELLOW);
        g.fillRect(arı.x, arı.y, arı.getGenislik(), arı.getYukseklik());
    }
}

public class HareketliEngelTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Engel Uygulaması");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setContentPane(new HaritaPaneli());
        frame.setVisible(true);
    }
}
