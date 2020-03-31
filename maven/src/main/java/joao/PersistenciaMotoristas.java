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

public class PersistenciaMotoristas{
    private static final String SAMPLE_CSV_FILE_PATH = "motoristas.dat";

    public List<Motorista> carregaMotoristas() {
        ArrayList<Motorista> listaMotorista = new ArrayList();
        try (
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String cpf = csvRecord.get(0);
                String nome = csvRecord.get(1);
                FormaPagamento formaPagto = FormaPagamento.valueOf(csvRecord.get(2).trim());
                listaMotorista.add(new Motorista(cpf, nome, formaPagto));
            }
        }
        catch(IOException e){
            System.out.println("Não foi possível encontrar motoristas.dat" + e.getMessage());
            System.exit(0);
        }
        return listaMotorista;
    }

    public boolean persistenciaMotoristas(List<Motorista> lista){
        try (CSVPrinter printer = new CSVPrinter(new FileWriter(new File("motoristas.dat")), CSVFormat.EXCEL);){
            printer.printRecord("cpf", "nome", "formaPagto");
            for(Motorista v : lista){
                printer.printRecord(v.getCpf(), v.getNome(), v.getFormaPagto());
            }
            return true;
        } catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}