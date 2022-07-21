package API.Tratamento;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class GeradorFigurinhas {
    public void cria(InputStream inputStream, String nomeArquivo) throws IOException {
        // leitura da imagem
        // InputStream inputStream = new FileInputStream("img/filme.jpg");
        BufferedImage imgOriginal = ImageIO.read(inputStream);

        // criar nova imagem e aplicar transparencia e redimensionamento
        BufferedImage novaImagem = new BufferedImage(
                imgOriginal.getWidth(),
                imgOriginal.getHeight() + 200, BufferedImage.TRANSLUCENT
        );

        // copiar a imagem original para a nova (em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imgOriginal, 0, 0, null);

        // configurar a fonte
        int largura = novaImagem.getWidth();
        int altura = novaImagem.getHeight();

        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, altura/12));

        // adiciona a frase/palavra
        // calculo de poscionamento -> (largura - tamanhoTexto) / 4 -> onde o texto ocupara de 25% - 75% da imagem
        graphics.drawString("EI_PI_AI", (largura-graphics.getFont().getSize())/4, novaImagem.getHeight());

        // escrever nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("img/"+nomeArquivo));
    }
}
