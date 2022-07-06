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
    public partial class Anaskopisi : Form
    {
        public Anaskopisi()
        {
            InitializeComponent();
        }

        private void label2_Click(object sender, EventArgs e)
        {
            // opens axiotheata
            Axiotheata form = new Axiotheata();
            form.Show();
        }

        private void label3_Click(object sender, EventArgs e)
        {
            //opens history
            History form = new History();
            form.Show();
        }

        private void label4_Click(object sender, EventArgs e)
        {
            //opens ethima form
            Ethima form = new Ethima();
            form.Show();
        }

        private void label5_Click(object sender, EventArgs e)
        {
            //opens photo gallery
            Photos form = new Photos();
            form.Show();
        }

        private void label6_Click(object sender, EventArgs e)
        {
            AgiosNikolaosForm form = new AgiosNikolaosForm();
            form.Show();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
