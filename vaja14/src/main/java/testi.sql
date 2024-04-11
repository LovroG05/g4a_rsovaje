SELECT igra, COUNT(*) AS total FROM rezultati GROUP BY igra;

SELECT * FROM rezultati WHERE igra="Apex" ORDER BY rezultat DESC LIMIT 10;

SELECT igralec, COUNT(*) AS ponovitve
FROM rezultati
WHERE igra="Apex"
GROUP BY igralec
ORDER BY ponovitve ASC
LIMIT 10;

SELECT * FROM rezultati ORDER BY konec DESC;

SHOW CREATE TABLE rezultati;
