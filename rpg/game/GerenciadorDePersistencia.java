package rpg.game;

import java.io.File;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import rpg.cenario.FaseDeCombate;
import rpg.eventos.Hermes;
import rpg.itens.weapons.Bow;
import rpg.itens.weapons.Club;
import rpg.itens.weapons.Spear;
import rpg.itens.weapons.Sword;
import rpg.personagens.herois.Demigod;
import rpg.personagens.herois.Satyr;
import rpg.personagens.monstros.Chimera;
import rpg.personagens.monstros.Ciclop;
import rpg.personagens.monstros.Harpy;

public class GerenciadorDePersistencia {
    /**
     * Salva o estado atual de um objeto Batalha em um arquivo XML.
     * @param batalha O objeto Batalha contendo todo o estado do jogo a ser salvo.
     * @param nomeArquivo O nome do arquivo (save do jogo).
     */
    public static void salvarBatalha(Batalha batalha, String nomeArquivo) {
        try {
            JAXBContext context = JAXBContext.newInstance(Batalha.class, Demigod.class, Satyr.class, Ciclop.class, Harpy.class,
            Chimera.class, Sword.class, Bow.class, Club.class, Spear.class, FaseDeCombate.class, Hermes.class);
            
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(batalha, new File(nomeArquivo));
            System.out.println("\nJogo salvo com sucesso em: " + nomeArquivo);

        } catch (JAXBException e) {
            System.err.println("Erro ao salvar o jogo");
            e.printStackTrace();
        }
    }
    /**
     * Carrega um jogo a partir de um XML.
     * @param nomeArquivo O nome do arquivo a ser carregado.
     * @return Um objeto Batalha carregado, ou null se falhar.
     */
    public static Batalha carregarBatalha(String nomeArquivo) {
        File arquivoDeSave = new File(nomeArquivo);

        if (!arquivoDeSave.exists()) {
            System.out.println("Nenhum jogo salvo encontrado com o nome: " + nomeArquivo);
            return null;
        }

        try {
            Class<?>[] classes = {Batalha.class, Demigod.class, Satyr.class, Ciclop.class, Harpy.class, Chimera.class, Sword.class, Bow.class, Club.class, Spear.class};
            JAXBContext context = JAXBContext.newInstance(classes);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            
            Batalha batalhaCarregada = (Batalha) unmarshaller.unmarshal(arquivoDeSave);
            
            System.out.println("Jogo carregado com sucesso! Continuando a aventura...");
            return batalhaCarregada;
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Verifica se existe um jogo salvo com um nome específico.
     * @param nomeArquivo O nome do arquivo a ser verificado.
     * @return true se o arquivo existe, false caso contrário.
     */
    public static boolean existeJogoSalvo(String nomeArquivo) {
        return new File(nomeArquivo).exists();
    }
}