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

public class PersistenciaVeiculos{
    private static final String SAMPLE_CSV_FILE_PATH = "veiculos.dat";

    public List<Veiculo> carregaVeiculos() throws IOException{
        ArrayList<Veiculo> listaVeiculos = new ArrayList();
        try (
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String placa = csvRecord.get(0);
                String marca = csvRecord.get(1);
                String cor = csvRecord.get(2);
                String categoria = csvRecord.get(3);
                listaVeiculos.add(new Veiculo(placa, marca, cor, categoria));
            }
        }
        catch(IOException e){
            System.out.println("Não foi possível encontrar veiculos.dat");
            System.exit(0);
        }
        return listaVeiculos;
    }

    public boolean persistenciaVeiculos(List<Veiculo> lista){
        try (CSVPrinter printer = new CSVPrinter(new FileWriter(new File("veiculos.dat")), CSVFormat.EXCEL);){
            printer.printRecord("placa", "marca", "cor", "categoria");
            for(Veiculo v : lista){
                printer.printRecord(v.getPlaca(), v.getMarca(), v.getCor(), v.getCategoria());
            }
            return true;
        } catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}