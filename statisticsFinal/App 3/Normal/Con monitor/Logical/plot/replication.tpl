set term postscript eps color blacktext "Helvetica" 30
set output "../graphics/replication.eps"
set key right top
set grid y
set yrange[0:4]
set ytics 1
set xtics 200
set xlabel 'Time (s)'
set ylabel "# Replicas"
set key spacing 1 font ",15"
set datafile separator ","
plot "../statistics/replication@processElements.ProcessOnePE.csv" using 1:2 title 'Operator 1' with lines lw 3 lc 1, \
	"../statistics/replication@processElements.ProcessTwoPE.csv" using 1:2 title 'Operator 2' with lines lw 3 lc rgb '#006600', \
	"../statistics/replication@processElements.MongoPE.csv" using 1:2 title 'Operator 3' with lines lw 3 lc 3
exit