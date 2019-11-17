using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace WindowsApplication1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            try
            {
                openFileDialog1.ShowDialog();
                pictureBox1.Image = Image.FromFile(openFileDialog1.FileName);
            }
            catch (Exception ex)
            {
                ex.ToString();
            }
        }

        private void openFileDialog1_FileOk(object sender, CancelEventArgs e)
        {
        }

        private void webBrowser1_DocumentCompleted(object sender, WebBrowserDocumentCompletedEventArgs e)
        {
        }

        private void driveListBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            dirListBox1.Path = driveListBox1.Drive;
        }

        private void dirListBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            fileListBox1.Path = dirListBox1.Path;
        }

        private void fileListBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            pictureBox1.Image = Image.FromFile(fileListBox1.Path+"\\"+fileListBox1.FileName);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            fileListBox1.SelectedIndex = 0;
        }
    }}