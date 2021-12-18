package controls;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Datas {

    public String somaDias(Date hoje, int quantosDias){
        Date dataHoje = hoje;
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataHoje);
        cal.add(Calendar.DATE, quantosDias);//mais x dias
        Date dataHojeMais5Dias = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        String dataTexto = sdf.format(dataHojeMais5Dias);
        return dataTexto;
    }
}
