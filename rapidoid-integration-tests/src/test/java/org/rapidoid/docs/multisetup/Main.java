/*-
 * #%L
 * rapidoid-integration-tests
 * %%
 * Copyright (C) 2014 - 2018 Nikolche Mihajlovski and contributors
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

package org.rapidoid.docs.multisetup;

import org.rapidoid.docs.multisetup.barsetup.BarSetupCtrl;
import org.rapidoid.docs.multisetup.foosetup.FooSetupCtrl;
import org.rapidoid.http.HTTP;
import org.rapidoid.setup.App;
import org.rapidoid.setup.Setup;
import org.rapidoid.setup.Setups;

public class Main {

	public static void main(String[] args) {
		App.run(args);

		Setup setup1 = Setups.create("foo").port(2222);
		Setup setup2 = Setups.create("bar").port(3333);

		setup1.scan(FooSetupCtrl.class.getPackage().getName());
		setup2.scan(BarSetupCtrl.class.getPackage().getName());

		// demo
		HTTP.get("localhost:2222/foo").print();
		HTTP.get("localhost:3333/bar").print();
	}

}
