import pyspark
asdf
print(pyspark.SparkContext().parallelize(range(0, 10)).count())
