[:select {:where <where> :order _ :offset _ :limit _ :only _}]
=> [<record> <record> <record>]

[:count {:where <where> :order _ :offset _ :limit _}]
=> <count>

[:insert {:records _}]
=> [<db> <count>]

[:update {:where <where> :order _ :offset _ :limit _ :with _}]
=> [<db> <count>]

[:delete {:where <where> :order _ :offset _ :limit _}]
=> [<db> <count>]

[:create-index {:on <index_on>}]
=> [<db> 1]

[:drop-index {:on <index_on>}]
=> [<db> 1]

[:list-indexes]
=> [<index_on> <index_on> <index_on>]

[:multi-read  {:queries [<select> <count>]}]
=> [<records> <count>]

[:multi-write {:queries [<insert> <update> <delete> <index>]}]
=> [<db> [<count> <count> <count> <count>]]

[:checked-write {:check  <read_or_multi-read>
                 :expect <expected result>
                 :write  <write_or_multi-write>}]
=> nil
=> [<db> <count>]
=> [<db> [<records> <count>]]

[:explain {:query [:select _]}]
=> <query_plan>