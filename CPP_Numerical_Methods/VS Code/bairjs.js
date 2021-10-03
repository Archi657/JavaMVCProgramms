private void PaymentMethodChangeEvent()
var interacion = 1;
double r;
double s;
List<double> a new List<double>();
List<double> b new List<double>();
List<double> c new List<double>();
List<string> allLines = new List<string>();

if(initialRun){
    in_aCoeff = textBox1.Text;
}
var aCoeff = in_aCoeff.Split(',');
var degree = aCoeff.Count()-1;
var aCoeff_count= degree;

if(Convert.ToDouble(aCoeff[0]==0)){
    MessageBox.show("No comienza con 0","Error",MessageBoxButtons.OK,MessageBo)
    return;
}
if(aCoeff.Count()< 4){
    MessageBox.Show("dsada")
    return;
}
while(true){
    allLines.add("-----")
    allLines.add("Iteration count "+ interacion++);

    b= new List<double>();
    c= new List<double>();
    var a_ctr = 0;
    foreach (double ai in a){
        double _bi;
        if(a_ctr==0){
            _bi = ai;
            b.Add(_bi);
            a_ctr++;
            continue;
        }else if(a_ctr == 1){
            _bi = a[1]+b[0]*r;
        }else{
            _bi = a[a_ctr]+b[a_ctr-1]*r+b[a_ctr-2]*s;
        }
    }

    if(Er>Ea || Es > Ea){
        r = newR;
        s= newS;

        allLines.add(" ");
        allLines.add("Siguiente iteracion")
        allLines.add("r= "+ Math.round(r, decimalDigit, MidpointRounding.awayfromzero).toString())
        allLines.add("s= "+ Math.round(s, decimalDigit, MidpointRounding.awayfromzero).toString())
        continue;
    }else{
        final_r = r ;
        final_s = s ;
        allLines.add(" ");
        allLines.Add("Iteracion detenida, error alcannsado");
        allLines.Add(Ea.toString());
        break;
    }
}
}