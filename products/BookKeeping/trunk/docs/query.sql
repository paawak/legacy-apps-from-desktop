/*total amount paid per flat per year*/
SELECT flat, EXTRACT(YEAR FROM paidon) as paydate, SUM(amountpaid) FROM fundcollection GROUP BY flat, paydate order by flat;

/*total amount paid per flat*/
SELECT flat, SUM(amountpaid) FROM fundcollection GROUP BY flat order by flat;


/*to find the diesel bought per month*/
SELECT SUM(e.amount) AS DIESEL_COST, TO_CHAR(DATE_TRUNC('month', e.expensedate), 'Mon YY') AS MONTH, DATE_TRUNC('month', e.expensedate) AS DATE 
FROM expenses e WHERE e.description ILIKE '%diesel%' GROUP BY DATE ORDER BY DATE


select sum(amountpaid) as total_fund_collection from fundcollection

