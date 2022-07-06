using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MyEasterDestination
{
    public partial class Intro : Form
    {
        public Intro()
        {
            InitializeComponent();
        }

        private void pictureBox5_Click(object sender, EventArgs e)
        {
            //Shows the intro form
            Anaskopisi form = new Anaskopisi();
            form.Show();
        }
    }
}
