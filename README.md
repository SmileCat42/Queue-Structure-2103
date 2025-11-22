<h1 align="center"><b>Project Stack โปรเจคแถวคอย</b></h1>
<p align="center">
And java.util.QueueList และการใช้คำสั่งยูทิลคิว
</p>

<br><br>หน้าจอโหลด Loading Page (กดเล่น gif ได้ can click play button)<br>
![นี่คือรูปหน้าจอ Login](https://github.com/SmileCat42/Queue-Structure-2103/blob/master/src/image/GHplane.gif)

<br><br>ภายในโปรแกรม Program Page 
![นี่คือรูปหน้าจอ Login](https://github.com/SmileCat42/Queue-Structure-2103/blob/master/src/image/01.png)

<br><br>กำหนดเงื่อนไขกระเป๋า Condition Page 
![นี่คือรูปหน้าจอ Login](https://github.com/SmileCat42/Queue-Structure-2103/blob/master/src/image/08.png)

<br><br>

[English](#english) | [ภาษาไทย](#ภาษาไทย)

<br>

<a id="ภาษาไทย"></a>

<h1 align="center"><b>COS2103</b></h1>
<h3 align="center">Data Structure and Algorithm โครงสร้างข้อมูลและอัลกอริทึม</h3>

<br><br>
<h2 style="text-indent: 2em; text-decoration: underline;">จุดประสงค์ของการทำโปรเจค</h2>
&nbsp;&nbsp;&nbsp;&nbsp;เนื่องจากโครงสร้างประเภท Array, Stack, Queue และ LinkedList เป็นโครงสร้างที่ไม่ได้มีความซับซ้อนมาก อาจารย์จึงอยากให้นักศึกษาเข้าใจแบบจริงๆ โดยการให้นักศึกษาถ่ายทอดความเข้าใจของตนเองผ่านทางโปรแกรม Apache Netbeans เพื่อเป็นการฝึกการใช้งานโปรแกรมเบื้องต้นด้วย โดยการนำไปใช้งานกับอัลกอริทึมในแบบต่างๆ ที่มีการใช้งานบ่อย เช่น การแทรกข้อมูล การลบข้อมูล การค้นหา เป็นต้น
<br>
<br>

<h2 style="text-indent: 2em; text-decoration: underline;">เนื้อหาที่ได้รับ</h2>
1. เข้าใจโครงสร้างของคิวว่ามีรูปแบบการทำงานเป็นอย่างไร ลำดับเข้า-ออกของข้อมูลที่ใส่บนโครงสร้างแถวคอยเป็นอย่างไร สามารถยกตัวอย่างในชีวิตจริงหรือเห็นการทำงานต่างๆบนระบบคอมพิวเตอร์ก็สามารถบอกได้ว่าเป็นโครงสร้างประเภทใด
<br>2. ทราบถึงข้อจำกัดในการเข้าถึงตำแหน่งภายในโครงสร้างแถวคอย ซึ่งแตกต่างจากอาเรย์ที่สามารถระบุตำแหน่งได้เลย
<br>3. ได้มีการใช้อัลกอริทึมหลากหลายรูปแบบ มีการ import java.util.QueueList เข้ามาใช้งาน เพื่อทำให้เข้าใจความแตกต่างระหว่างคิวปกติและยูทิลคิว
<br>4. ทำให้นักศึกษาสามารถตัดสินใจเลือกใช้อัลกอริทึมที่เหมาะสมที่สุด มาประยุกต์ใช้งานกับคำสั่งบนแถวคอยแต่ละแบบได้

<br>
<br>
<h2 style="text-indent: 2em; text-decoration: underline;">ผลการรันโปรแกรม</h2>
📄 <a href="src/image/24.png" target="_blank">โจทย์โปรเจค</a><br>

📄 [ดูผลการรันโปรแกรม](https://www.canva.com/design/DAG1H5kL8mk/WHUUVpAH2G2tuScLTkmaZg/edit?utm_content=DAG1H5kL8mk&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton)

<br>
<br>
<h2 style="text-indent: 2em; text-decoration: underline;">ผลการเรียนรู้</h2>
📄 <a href="src/image/exam2103.pdf" target="_blank">ข้อสอบ</a><br>
📄 <a href="src/score/score.pdf" target="_blank">คะแนนทั้งระดับชั้น</a>
<br>
<br>

<h2 style="text-indent: 2em; text-decoration: underline;">ขั้นตอนการเปิดโปรแกรม</h2>
1. ติดตั้งโปรแกรม Apache Netbeans
<br>2. ดาวน์โหลดโปรเจคนี้ลงเครื่อง (ปุ่ม CODE สีเขียว)
<br>3. เปิดโปรแกรม Netbeans เลือกที่ File > Open Project เลือกไฟล์เป็นโปรเจคนี้ที่ดาวน์โหลดไว้
<br>4. สังเกตุแถบซ้ายมือจะมีชื่อไฟล์ที่โหลดมาไอคอนถ้วยกาแฟ กดคลิ็กดรอปดาวน์ลงมา กดลงมาต่อที่ Source Packages กดลงมาต่อที่ projectstack (หรือกดลงอีกโฟลเดอร์นึงคือ javautilQueue เพื่อดูฉบับ util.queue)
<br>5. คลิ๊กขวาที่ชื่อไฟล์ Face2.java แล้วเลือก Run File
<br><br><br><br>
<a id="english"></a>

<h2 style="text-indent: 2em; text-decoration: underline;">Project Objective</h2>
&nbsp;&nbsp;&nbsp;&nbsp;Since data structures such as Array, Stack, Queue, and LinkedList are not highly complex, the instructor would like students to gain a true understanding of them by expressing our knowledge through programming in Apache NetBeans. This method also serves as basic practice in using program. The project applying these structures to commonly used algorithms such as insertion, deletion, and searching, among others.
<br>
<br>

<h2 style="text-indent: 2em; text-decoration: underline;">Content Received</h2>
1. Understand how queue structure works in terms of the order of data being insert at Rear or delete at Front, can provide examples on reallife or computer systems to show which type of structure they represent
<br>2. Understood that can’t access elements directly in queue like array
<br>3. Tried different algorithms and used java.util.Queue to see the difference between a regular queue and a java.util.queue
<br>4. Learned how to choose the most suitable algorithm for different queue operations
<br>
<br>
<h2 style="text-indent: 2em; text-decoration: underline;">Program Result</h2>
📄 <a href="src/image/24.png" target="_blank">Assignment</a><br>

📄 [Report program output](https://www.canva.com/design/DAG1H5kL8mk/WHUUVpAH2G2tuScLTkmaZg/edit?utm_content=DAG1H5kL8mk&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton)
<br>
<br>
<h2 style="text-indent: 2em; text-decoration: underline;">Learning Outcomes</h2>
📄 <a href="src/image/exam2103.pdf" target="_blank">Exam</a><br>
📄 <a href="src/score/score.pdf" target="_blank">Score all section</a>
<br>
<br>
<h2 style="text-indent: 2em; text-decoration: underline;">How to open the program</h2>
1. Install Apache NetBeans IDE
<br>2. Download this project to your computer (click green CODE button)
<br>3. Open NetBeans, go to File > Open Project, and select this downloaded project
<br>4. On the left panel, you will see the project name with coffee cup icon, click dropdown arrow to expand it, then open Source Packages → travelbagsqueue (→ javautilQueue if you want to open util.queue version)
<br>5. Right-click on the file Face2.java and select Run File to execute the program.
