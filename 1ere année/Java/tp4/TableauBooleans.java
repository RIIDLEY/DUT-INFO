public class TableauBooleans{

        private boolean [] tab;

        public String toString(){
          String a = "|";
          for (int i=0; i< this.tab.length ; i++ ) {
            a = a + this.tab[i] +"|";
          }
          return a;
               }

        public TableauBooleans(){
        }

        public TableauBooleans(boolean[] t){
          this.tab=t;
        }

        public TableauBooleans (TableauBooleans tb){
            int n = tb.tab.length;
            this.tab = new boolean[n];
            for ( int i = 0; i<this.tab.length ; i++ ) {
              this.tab[i]=tb.tab[i];
            }
        }

        public int taille(){
          return this.tab.length;
        }

        public void setTableau(int i, boolean val){
          this.tab[i]=val;
        }

        public boolean getTableau(int i){
          return this.tab[i];
        }

        public TableauBooleans et(TableauBooleans tb){
          boolean [] t1 = new boolean [this.tab.length] ;
          TableauBooleans tb2 = new TableauBooleans(t1);
          for (int i=0; i<this.tab.length ; i++) {
            tb2.tab[i]=tb.tab[i] && this.tab[i];
          }
          return tb2;
        }

        public boolean et(){
          for (int i = 0; i < this.tab.length ; i++) {
            
          }
        }
}
