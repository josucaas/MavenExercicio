package joao;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVPrinter;

import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PersistenciaPassageiros {
    private static final String SAMPLE_CSV_FILE_PATH = "passageiros.dat";
    
    public List<Passageiro> carregaPassageiros(){
        List<Passageiro> Passageiros = new ArrayList<Passageiro>();
        try (
        Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
        ) {
            for (CSVRecord csvRecord : csvParser) {
                String CPF = csvRecord.get(0);
                String nome = csvRecord.get(1);
                FormaPagamento pagamento = FormaPagamento.valueOf(csvRecord.get(2).trim());
                String numCartao = csvRecord.get(3);
                
                Passageiro passageiro = new Passageiro(CPF,nome,pagamento,numCartao);
                Passageiros.add(passageiro);
            }
        }
        catch(IOException e){
            System.out.println("Não foi possível encontrar passageiros.dat");
            System.exit(0);
        }
        return Passageiros;
    }

    public boolean persistenciaPassageiros(List<Passageiro> lista){
        try (CSVPrinter printer = new CSVPrinter(new FileWriter(new File("Passageiros.dat")), CSVFormat.EXCEL);){
            printer.printRecord("CPF", "nome", "pagamento", "numCartao");
            for(Passageiro v : lista){
                printer.printRecord(v.getCPF(), v.getNome(), v.getPagamento(), v.getnumCartao());
            }
            return true;
        } catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}